package com.ling.Test1;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class livpToZip {

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\11525\\Desktop\\回忆录\\26";

        String str = new String();
        char[] str1 = new char[4];
        File file = new File(path);
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isFile() && f.getName().endsWith("livp")) {
                String fileName = f.getName().substring(0, f.getName().indexOf(".livp")) + ".zip";
                File fileNew = new File(path + fileName);
                f.renameTo(fileNew);
                ZipUncompress(fileNew, path);
                f.delete();
                fileNew.delete();
            }
        }
    }

    public static void ZipUncompress(File srcFile,String destDirPath) throws Exception {
        // 判断源文件是否存在
        if (!srcFile.exists()) {
            throw new Exception(srcFile.getPath() + "所指文件不存在");
        }
        //开始解压
        //构建解压输入流
        ZipInputStream zIn = new ZipInputStream(new FileInputStream(srcFile));
        ZipEntry entry = null;
        File file = null;
        while ((entry = zIn.getNextEntry()) != null) {
            if (!entry.isDirectory() && !entry.getName().endsWith(".mov")) {
                file = new File(destDirPath, entry.getName());
                if (!file.exists()) {
                    new File(file.getParent()).mkdirs();//创建此文件的上级目录
                }
                OutputStream out = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                int len = -1;
                byte[] buf = new byte[1024];
                while ((len = zIn.read(buf)) != -1) {
                    bos.write(buf, 0, len);
                }
                // 关流顺序，先打开的后关闭
                bos.close();
                out.close();
            }
        }
    }
}
