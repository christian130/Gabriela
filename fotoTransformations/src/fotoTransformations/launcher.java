package fotoTransformations;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class launcher {
public static void resizer(File orignalImage,int width,int height,String extension,int marcador) {
        
        try {
              BufferedImage origBuffImg = ImageIO.read(orignalImage);
              int type = origBuffImg.getType() == 0? BufferedImage.TYPE_INT_ARGB : origBuffImg.getType();
             
              BufferedImage resizedBuffImg = new BufferedImage(width, height, type);
              Graphics2D g = resizedBuffImg.createGraphics();
              g.drawImage(origBuffImg, 0, 0, width, height, null);
              g.dispose();
              System.out.println(orignalImage.getAbsolutePath().substring(0,orignalImage.getAbsolutePath().lastIndexOf("fotoTransformations"))+"\\out");
              System.out.println(orignalImage.getAbsolutePath().substring(0,orignalImage.getAbsolutePath().lastIndexOf(".")));
             
              String newFile = orignalImage.getAbsolutePath().substring(0,orignalImage.getAbsolutePath().lastIndexOf("fotoTransformations"))+"\\fotoTransformations\\out\\"+String.valueOf(marcador)+"_"+width+"x"+height+"."+extension;
              ImageIO.write(resizedBuffImg, extension, new File(newFile));
             
              System.out.println("File created : "+newFile);
             
        } catch (IOException e) {
              e.printStackTrace();
        }
  }

public static void search(final String pattern, final File folder, List<String> result) {
    for (final File f : folder.listFiles()) {

        if (f.isDirectory()) {
            search(pattern, f, result);
        }

        if (f.isFile()) {
            if (f.getName().matches(pattern)) {
                result.add(f.getAbsolutePath());
            }
        }

    }
}
	public static void main(String[] args) {
	    final File folder = new File(".");

	        List<String> result = new ArrayList<>();

	        search(".*\\.png", folder, result);
int i=0;
	        for (String s : result) {
	            
	           //System.out.println(s);
	            File file = new File (s);
	            i++;
	            
	            resizer(file,292,519,"PNG",i);
	        }

	}

}
