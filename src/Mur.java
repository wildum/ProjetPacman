
public class Mur {
	
	
	private int position_x, position_y, type;
	private int width = 4;
	protected double hitbox_x1, hitbox_x2, hitbox_y1, hitbox_y2;
	
	public Mur(int x, int y, int type)
	{
		this.position_x = x;
		this.position_y = y;
		this.type = type;
		
		this.hitbox_x1 = position_x-width;
		this.hitbox_x2 = position_x+width;
		this.hitbox_y1= position_y-width;
		this.hitbox_y2 = position_y+width;
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
	public int getType()
	{
		return this.type;
	}
}
