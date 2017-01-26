
public class Graine {
	
	protected int pos_x, pos_y;
	protected String type;
	protected static double width = 0.5;
	protected double hitbox_x1, hitbox_x2, hitbox_y1, hitbox_y2;
	
	/*
	 * Constructeur de la classe
Prend en argument la position en x et y que doit avoir la graine ainsi que son état (“standard”, “super” ou “null”)

	 */
	public Graine(int pos_x, int pos_y, String type)
	{
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.type = type;
		this.hitbox_x1 = pos_x-width;
		this.hitbox_x2 = pos_x+width;
		this.hitbox_y1= pos_y-width;
		this.hitbox_y2 = pos_y+width;
	}
	
	public int getPos_x()
	{
		return this.pos_x;
	}
	
	public int getPos_y()
	{
		return this.pos_y;
	}
	
	
	public String getType()
	{
		return this.type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public double gethx1()
	{
		return this.hitbox_x1;
	}
	public double gethx2()
	{
		return this.hitbox_x2;
	}
	public double gethy1()
	{
		return this.hitbox_y1;
	}
	public double gethy2()
	{
		return this.hitbox_y2;
	}
}
