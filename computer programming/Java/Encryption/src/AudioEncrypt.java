import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AudioEncrypt {
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

	AudioEncrypt(String message) throws LineUnavailableException, IOException {
		int num = message.length();
		final AudioFormat af = new AudioFormat(Note.SAMPLE_RATE, 8, 1, true,
				true);
		SourceDataLine line = AudioSystem.getSourceDataLine(af);
		line.open(af, Note.SAMPLE_RATE);
		line.start();
		String Notes[] = { "E", "F", "G", "A1", "B1", "C1", "D1", "E1", "F1",
				"A2", "REST" };
		for (int i = 0; i < num; i++)
			play(line, Note.valueOf(Notes[Integer.parseInt(String
					.valueOf(message.charAt(i) != '.' ? message.charAt(i)
							: "10"))]), 50);
		line.drain();
		line.close();
	}

	private static void play(SourceDataLine line, Note note, int ms) {
		int count = line.write(note.data(), 0, Note.SAMPLE_RATE * ms / 1000);
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