//pd.7 Noah Heath 4/22/14
public class Box {
	public double Height;
	public double Width;
	public double Depth;

	public Box(double h, double w, double d) {
		Height = h;
		Width = w;
		Depth = d;
	}

	public double getHeight() {
		return Height;
	}

	public double getWidth() {
		return Width;
	}

	public double getDepth() {
		return Depth;
	}

	public void setHeight(double newHeight) {
		Height = newHeight;
	}

	public void setWidth(double newWidth) {
		Width = newWidth;
	}

	public void setDepth(double newDepth) {
		Depth = newDepth;
	}
	
	public boolean full(){
		return(Height>0&&Width>0&&Depth>0?true:false);
	}

	public String toString() {
		return "Height: " + Height + "\nWidth: " + Width + "\nDepth: " + Depth+"\n Full: "+full();
	}
}
