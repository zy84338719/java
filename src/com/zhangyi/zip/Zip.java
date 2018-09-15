package com.zhangyi.zip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zip {

    public static void unit(String outFileName, String fileFolder, final String filterName) throws IOException {
        File[] inFiles;
        File outFile = new File(outFileName);
        File inFilesFolder = new File(fileFolder);

        if(!inFilesFolder.exists()) {
            throw new FileNotFoundException("Source file folder not found.filePath:" + fileFolder);
        }

        inFiles = inFilesFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String fileName = new File(name).getName();
                return fileName.startsWith(filterName);
            }
        });
        Long addr = 0L;
        RandomAccessFile out = new RandomAccessFile(outFile, "rw");
        out.seek(0);
        for (File file : inFiles) {
            RandomAccessFile infile = new RandomAccessFile(file, "r");
            myFile myfile = new myFile(file.getName(),System.currentTimeMillis(),infile.length(),addr);
            addr = infile.length();
            out.writeUTF(myfile.toString());
            infile.close();
        }
        out.writeUTF("-----");
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


    public static void cut(String filePath, String filterFolder) throws IOException {
        File file = new File(filePath);
        if(!file.exists()) {
            throw new FileNotFoundException("Source file not found.filePath:" + filePath);
        }
        File storeFiles = new File(filterFolder);
        if(!storeFiles.exists()){
            storeFiles.mkdirs();
        }
        RandomAccessFile sourceFile = new RandomAccessFile(filePath, "r");
        String s = sourceFile.readUTF() ;
        List<myFile> myFileList = new ArrayList<>();
        while (!s.equals("-----"))
        {
            String[] f = s.split(",");
            myFile myfile = new myFile(f[0],Long.parseLong(f[1]),Long.parseLong(f[2]),Long.parseLong(f[3]));
            System.out.println(s);
            myFileList.add(myfile);
            s = sourceFile.readUTF();
        }
        Long py = sourceFile.getFilePointer();
        for(myFile myfile:myFileList) {
            RandomAccessFile outFile = new RandomAccessFile(storeFiles.getAbsolutePath()+File.separator+myfile.getName(), "rw");
            for(int j = py.intValue()+myfile.getAddr().intValue(); j< myfile.getLength() + myfile.getAddr().intValue()+ py.intValue(); j ++) {
                outFile.write(sourceFile.read());
            }
            outFile.close();
        }
        sourceFile.close();
    }
}
