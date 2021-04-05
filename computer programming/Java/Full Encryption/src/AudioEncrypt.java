import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//Fix the visual
public class AudioEncrypt extends JFrame{
	static byte b;
	/*
	File dstFile = new File("");
	FileOutputStream out = new FileOutputStream(dstFile);
/*
	int len;
	while ((len = in.read(buf)) > 0) {
	    out.write(buf, 0, len);
	}
	 out.close();
	 */
	
	JPanel sound;
	String Message = "";
	int j = 0;

	AudioEncrypt(String message) throws LineUnavailableException, IOException , InterruptedException{
		Message = message;
		int num = message.length();
		final AudioFormat af = new AudioFormat(Note.SAMPLE_RATE, 8, 1, true,
				true);
		SourceDataLine line = AudioSystem.getSourceDataLine(af);
		line.open(af, Note.SAMPLE_RATE);
		line.start();
		String Notes[] = { "E", "F", "G", "A1", "B1", "C1", "D1", "E1", "F1",
				"A2", "REST" };
		sound = new JPanel();
		this.setSize(500, 300);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocation(500,500);
		this.add(sound, BorderLayout.CENTER);
		for (int i = 0; i < num; i++){
			play(line, Note.valueOf(Notes[Integer.parseInt(String
					.valueOf(message.charAt(i) != '.' ? message.charAt(i)
							: "10"))]), 50);
			j=i;
			repaint();
		}
		line.drain();
		line.close();
		
	}

	private static void play(SourceDataLine line, Note note, int ms) {
		int count = line.write(note.data(), 0, Note.SAMPLE_RATE * ms / 1000);
	}


private class audioShow extends JPanel{
	
	public void paintComponent(Graphics p){
		int i = Integer.parseInt(String
				.valueOf(Message.charAt(j) != '.' ? Message.charAt(j)
						: "10"));
		Color c = new Color(255,0,0);
		switch(i){
		
		case 0:
			c = new Color(255,0,0);
		case 1:
			c = new Color(255,0,255);
		case 2:
			c = new Color(185,0,255);
		case 3:
			c = new Color(0,0,255);
		case 4:
			c = new Color(0,130,255);
		case 5:
			c = new Color(0,255,255);
		case 6:
			c = new Color(0,255,130);
		case 7:
			c = new Color(0,255,0);
		case 8:
			c = new Color(130,255,0);
		case 9:
			c = new Color(255,255,0);
		case 10:
			c = new Color(255,130,0);
		}
		p.fillRect(0, 0, 1000, 1000);
	}
}

}

enum Note {
	E, F, G, A1, B1, C1, D1, E1, F1, A2, REST;// configurable
	public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz(configurable)
	private byte[] sin = new byte[SAMPLE_RATE];

	Note() {
		int n = this.ordinal();
		if (n > 0)
			for (int i = 0; i < sin.length; i++)
				sin[i] = (byte) (127f * Math.sin((55.0 * Math.PI * i * Math
						.pow(2d, ((n + 47) / 12d))) / SAMPLE_RATE));
	}

	public byte[] data() {
		return sin;
	}

}