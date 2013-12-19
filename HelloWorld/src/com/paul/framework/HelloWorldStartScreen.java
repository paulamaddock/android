package com.paul.framework;

import com.paul.framework.Graphics.PixmapFormat;

public class HelloWorldStartScreen extends Screen{
	
	Pixmap myPic;
	int x= 0;
	
	public HelloWorldStartScreen(Game game){
		super (game);
		myPic = game.getGraphics().newPixmap("data/game.png", PixmapFormat.RGB565);
		
	}
	
	@Override
	public void update(float deltaTime){
		x += 50 * deltaTime;
		if (x > 100){
			x = 0;
		}
	}
	
	@Override
	public void present(float deltaTime){
		game.getGraphics().clear(0);
		game.getGraphics().drawPixmap(myPic, x, 0, 0, 0, myPic.getWidth(), myPic.getHeight());
	}
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	@Override
	public void dispose() {
		myPic.dispose();
	}
}
