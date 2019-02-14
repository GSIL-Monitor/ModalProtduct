/**
 * 
 */
package com.huimin.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 压缩工具类
 * 
 * 作者: zhoubang 日期：2015年3月26日 下午1:36:00
 */
public class ZipUtils {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final int  BUFFER_SIZE = 2 * 1024;
    /**
     * 压缩文件夹
     *
     * @param zipFileName
     *            打包后文件的名称，含路径
     * @param sourceFolder
     *            需要打包的文件夹或者文件的路径
     * @param zipPathName
     *            打包目的文件夹名,为空则表示直接打包到根
     */
    public static void zip(String zipFileName, String sourceFolder,
            String zipPathName) throws Exception {
        ZipOutputStream out = null;
        try {
            File zipFile = new File(zipFileName);

            FolderUtils.mkdirs(zipFile.getParent());
            out = new ZipOutputStream(zipFile);
            out.setEncoding(DEFAULT_CHARSET);
            if (StringUtils.isNotBlank(zipPathName)) {
                zipPathName = FilenameUtils.normalizeNoEndSeparator(zipPathName, true) + "/";
            } else {
                zipPathName = "";
            }
            zip(out, sourceFolder, zipPathName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * 压缩文件夹
     *
     * @param zipFile
     *            a {@link java.lang.String} object.
     * @param source
     *            a {@link java.lang.String} object.
     */
    public static void zip(String zipFile, String source) throws Exception {
        File file = new File(source);
        zip(zipFile, source, file.isFile() ? StringUtils.EMPTY : file.getName());
    }

    /**
     * 压缩文件夹
     *
     * @param zipFile
     *            a {@link java.io.File} object.
     * @param source
     *            a {@link java.io.File} object.
     */
    public static void zip(File zipFile, File source) throws Exception {
        zip(zipFile.getAbsolutePath(), source.getAbsolutePath());
    }

    private static void zip(ZipOutputStream zos, String file, String pathName)
            throws IOException {
        File file2zip = new File(file);
        if (file2zip.isFile()) {
            zos.putNextEntry(new ZipEntry(pathName + file2zip.getName()));
            IOUtils.copy(new FileInputStream(file2zip.getAbsolutePath()), zos);
            zos.flush();
            zos.closeEntry();
        } else {
            File[] files = file2zip.listFiles();
            if (ArrayUtils.isNotEmpty(files)) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        zip(zos, FilenameUtils.normalizeNoEndSeparator(f.getAbsolutePath(), true), FilenameUtils.normalizeNoEndSeparator(pathName + f.getName(), true) + "/");
                    } else {
                        zos.putNextEntry(new ZipEntry(pathName + f.getName()));
                        IOUtils.copy(new FileInputStream(f.getAbsolutePath()),
                                zos);
                        zos.flush();
                        zos.closeEntry();
                    }
                }
            }
        }
    }

    /**
     * 解压
     *
     * @param fromZipFile
     *            zip文件路径
     * @param unzipPath
     *            解压路径
     */
    @SuppressWarnings({  "resource" })
    public static final void unzip(String fromZipFile, String unzipPath)
            throws Exception {

        FileOutputStream fos = null;
        InputStream is = null;
        String path1 = StringUtils.EMPTY;
        String tempPath = StringUtils.EMPTY;

        if (!new File(unzipPath).exists()) {
            new File(unzipPath).mkdir();
        }
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(fromZipFile, DEFAULT_CHARSET);
        } catch (IOException e1) {
            e1.printStackTrace();
            throw new Exception(e1);
        }
        File temp = new File(unzipPath);
        String strPath = temp.getAbsolutePath();
        Enumeration<ZipEntry> enu = zipFile.getEntries();
        ZipEntry zipEntry = null;
        while (enu.hasMoreElements()) {
            zipEntry = (ZipEntry) enu.nextElement();
            path1 = zipEntry.getName();
            if (zipEntry.isDirectory()) {
                tempPath = FilenameUtils.normalizeNoEndSeparator(strPath + File.separator + path1, true);
                File dir = new File(tempPath);
                dir.mkdirs();
                continue;
            } else {

                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                try {
                    is = zipFile.getInputStream(zipEntry);
                    bis = new BufferedInputStream(is);
                    path1 = zipEntry.getName();
                    tempPath = FilenameUtils.normalizeNoEndSeparator(strPath + File.separator + path1, true);
                    FolderUtils.mkdirs(new File(tempPath).getParent());
                    fos = new FileOutputStream(tempPath);
                    bos = new BufferedOutputStream(fos);

                    IOUtils.copy(bis, bos);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new Exception(e);
                } finally {
                    IOUtils.closeQuietly(bis);
                    IOUtils.closeQuietly(bos);
                    IOUtils.closeQuietly(is);
                    IOUtils.closeQuietly(fos);
                }

            }
        }

    }
    /**
    
         * 压缩成ZIP 方法2
    
         * @param srcFiles 需要压缩的文件列表
    
         * @param out           压缩文件输出流
    
         * @throws RuntimeException 压缩失败会抛出运行时异常
    
         */
    
        public static void toZip(List<File> srcFiles , OutputStream out)throws RuntimeException {
    
            long start = System.currentTimeMillis();
    
            ZipOutputStream zos = null ;
    
            try {
    
                zos = new ZipOutputStream(out);
    
                for (File srcFile : srcFiles) {
    
                    byte[] buf = new byte[BUFFER_SIZE];
    
                   zos.putNextEntry(new ZipEntry(srcFile.getName()));
    
                    int len;
    
                    FileInputStream in = new FileInputStream(srcFile);
    
                    while ((len = in.read(buf)) != -1){
    
                        zos.write(buf, 0, len);
    
                    }
    
                    zos.closeEntry();
    
                    in.close();
    
                }
    
                long end = System.currentTimeMillis();
    
                System.out.println("压缩完成，耗时：" + (end - start) +" ms");
    
            } catch (Exception e) {
    
                throw new RuntimeException("zip error from ZipUtils",e);
    
            }finally{
    
                if(zos != null){
    
                    try {
    
                        zos.close();
    
                    } catch (IOException e) {
    
                        e.printStackTrace();
    
                    }
    
                }
    
            }
    
        }
        
        public static void unzip2(String fromZipFile, String unzipPath) {  
            // TODO Auto-generated method stub  
            long startTime=System.currentTimeMillis();  
            try {  
                ZipInputStream Zin=new ZipInputStream(new FileInputStream(  
                        fromZipFile));//输入源zip路径  
                BufferedInputStream Bin=new BufferedInputStream(Zin);  
                String Parent= unzipPath; //输出路径（文件夹目录）  
                File Fout=null;  
                java.util.zip.ZipEntry entry;  
                try {  
                    while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
                        Fout=new File(Parent,entry.getName());  
                        if(!Fout.exists()){  
                            (new File(Fout.getParent())).mkdirs();  
                        }  
                        FileOutputStream out=new FileOutputStream(Fout);  
                        BufferedOutputStream Bout=new BufferedOutputStream(out);  
                        int b;  
                        while((b=Bin.read())!=-1){  
                            Bout.write(b);  
                        }  
                        Bout.close();  
                        out.close();  
                        System.out.println(Fout+"解压成功");      
                    }  
                    Bin.close();  
                    Zin.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  
            long endTime=System.currentTimeMillis();  
            System.out.println("耗费时间： "+(endTime-startTime)+" ms");  
        } 
        
        public static void main(String[] args) throws Exception {
			File file1 = new File("C:\\Users\\ThinkPad\\Desktop\\1.txt");
            file1.createNewFile();
			File file2 = new File("C:\\Users\\ThinkPad\\Desktop\\2.txt");
			file2.createNewFile();
			List<File> list = new ArrayList<File>();
			list.add(file1);
			list.add(file2);
			FileOutputStream stream = new FileOutputStream(new File("C:\\Users\\ThinkPad\\Desktop\\zip.zip"));
			toZip(list, stream);
		}
}
