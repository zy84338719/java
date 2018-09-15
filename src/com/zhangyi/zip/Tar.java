package com.zhangyi.zip;

import java.io.*;

/**
 * @author zhangyi
 * 将规格化文件数据切分为指定大小文件组
 */
public class Tar {
    /**
     * @description
     * @param filePath 文件名称，包括路径
     * @param filterFolder 分割文件存放目录
     * @param fileSize 分割文件大小
     * @throws IOException
     */
    public static void cutFile(String filePath, String filterFolder, int fileSize) throws IOException {
        File file = new File(filePath);
        if(!file.exists()) {
            throw new FileNotFoundException("Source file not found.filePath:" + filePath);
        }
        File storeFiles = new File(filterFolder);
        if(!storeFiles.exists()){
            storeFiles.mkdirs();
        }
        RandomAccessFile sourceFile = new RandomAccessFile(filePath, "r");
        long sourceFileLen = sourceFile.length();
        long fileNum = sourceFileLen/fileSize;
        long readedLen = 0;
        int fileNameNum = 1;

        for(; fileNameNum <= fileNum; fileNameNum++) {
            RandomAccessFile outFile = new RandomAccessFile(storeFiles.getAbsolutePath()+File.separator+file.getName()+(fileNameNum)+"tmp", "rw");
            for(int j = 0; j< fileSize; j ++,readedLen++) {
                outFile.write(sourceFile.read());
            }
            outFile.close();
        }
        if(readedLen<sourceFileLen) {
            RandomAccessFile outFile = new RandomAccessFile(storeFiles.getAbsolutePath()+File.separator+file.getName()+(fileNameNum++)+"tmp", "rw");
            for(long j = readedLen; j< sourceFileLen; j ++) {
                outFile.write(sourceFile.read());
            }
            outFile.close();
        }
        sourceFile.close();
        System.out.println("文件长度："+sourceFileLen+"；单个文件长度："+fileSize+";文件分割个数："+(--fileNameNum));
    }



    /**
     * @description Unit files
     * @param outFileName 合并文件名称
     * @param fileFolder 被合并文件所在目录
     * @param filterName 被合并文件名过滤条件
     * @throws IOException
     */
    public static void unitFile(String outFileName, String fileFolder, final String filterName) throws IOException{
        File[] inFiles;
        File outFile = new File(outFileName);
        File inFilesFolder = new File(fileFolder);
        if(!inFilesFolder.exists()) {
            throw new FileNotFoundException("Source file folder not found.filePath:" + fileFolder);
        }
        //get confirmed condition files
        inFiles = inFilesFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String fileName = new File(name).getName();
                return fileName.startsWith(filterName);
            }
        });
        RandomAccessFile out = new RandomAccessFile(outFile, "rw");
        for (File file : inFiles) {
            System.out.println(file);
            RandomAccessFile infile = new RandomAccessFile(file, "r");
            int readed;
            while((readed = infile.read())!= -1){
                out.write(readed);
            }
            infile.close();
        }
        out.close();
    }

}
