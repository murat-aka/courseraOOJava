package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	
	public static int TRI_SIZE = 5;
	
	protected boolean inZone = false;
	
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	public boolean isInZone() {
		return inZone;
	}

	public void setInZone(boolean inZone) {
		this.inZone = inZone;
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		
		pg.pushStyle();
		pg.fill(100,255,100);
		pg.ellipse(x, y, 5, 5);
		pg.popStyle();
		
	
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {


		String name = getCity() + " " + getCountry() + " ";
		String pop = "";
		
		pg.pushStyle();
		
		pg.fill(255, 255, 255);
		pg.textSize(12);
		pg.rectMode(PConstants.CORNER);
		pg.rect(x, y-TRI_SIZE-39, Math.max(pg.textWidth(name), pg.textWidth(pop)) + 6, 39);
		pg.fill(0, 0, 0);
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.text(name, x+3, y-TRI_SIZE-33);
		pg.text(pop, x+3, y - TRI_SIZE -18);
		
		pg.popStyle();
		
		
	}
	
	private String getCity()
	{
		return getStringProperty("city");
	}
	
	private String getCountry()
	{
		return getStringProperty("country");
	}
	
	private float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}



	
}
