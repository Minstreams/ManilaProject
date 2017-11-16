package Components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Systems.RenderSystem;

public class RenderComponent extends RenderSystem {
	private String name;
	private ImageIcon imageIcon;
	private JLabel jLabel;
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	
	public JLabel getjLabel() {
		return jLabel;
	}
	public void setjLabel(JLabel jLabel) {
		this.jLabel = jLabel;
	}
	
	public RenderComponent(String name) {
		super();
		this.name = name;
		imageIcon = getImageFile(name);
		jLabel = new JLabel();
		jLabel.setOpaque(true);
		jLabel.setIcon(imageIcon);
		jLabel.setBounds(0/*gameObject.x*/,0/* gameObject.y*/, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
	}
	@Override
	protected void function() {
		// TODO Auto-generated method stub
		System.out.println("RenderComponent function");
		
	}

	public static ImageIcon getImageFile(String name) {
		String path = System.getProperty("user.dir")+"\\src";
		ImageIcon image = new ImageIcon(path+"\\"+name);
		return image;
	}
	
	public void ChangePos(int x,int y) {
		jLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
	}
}
