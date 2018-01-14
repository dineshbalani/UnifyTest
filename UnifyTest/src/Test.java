import java.util.Random;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub	
		//Initializing pixel array of size 128*128*3
		int pixels[]=new int[49152];
		System.out.println("Hello");
		//Calling getRandomNoFromWs to generate 10000 random no at a time
		int[] temp = getRandomNoFromWS(10000);
		for(int i=0;i<10000;i++) pixels[i] = temp[i];		
		temp = getRandomNoFromWS(10000);
		for(int i=10001;i<20000;i++) pixels[i] = temp[i];		
		temp = getRandomNoFromWS(10000);
		for(int i=20001;i<30000;i++) pixels[i] = temp[i];		
		temp = getRandomNoFromWS(10000);
		for(int i=30001;i<40000;i++) pixels[i] = temp[i];		
		temp = getRandomNoFromWS(9152);
		for(int i=40001;i<49152;i++)	pixels[i] = temp[i];
		
		//Converting pixel array to image
		Image image = getImageFromArray(pixels,128,128);
		
		//Displaying the image
		JFrame frame = new JFrame();
	    frame.getContentPane().add(new JLabel(new ImageIcon(image)));
	    frame.pack();
	    frame.setVisible(true);
	}
	
	public static int[] getRandomNoFromWS(int numToGenerate) throws Exception {		
		String ws = "https://www.random.org/integers/?num="+numToGenerate+"&min=0&max=255&col=1&base=10&format=plain&rnd=new";
		URL url = new URL(ws);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String output;
		int result[] = new int[numToGenerate];
		int i = 0;
		while ((output = in.readLine()) != null) {
			result[i++] = Integer.parseInt(output);
		}
		return result;		
	}
	
	public static Image getImageFromArray(int[] pixels, int width, int height) {		
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = (WritableRaster) image.getData();
        raster.setPixels(0,0,width,height,pixels);
        image.setData(raster); 
        return image;
    }

}
