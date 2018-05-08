package cnam.nsy209.selServices.association.client.view.helper;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * 
 * To wait during transfer
 *
 */
public class WaitingTransfer extends Composite {
	
	/* Attributes*/
	private HorizontalPanel panel;
	private TextAnim animation;
	private int width;
	private int height;
	
	/* Constructors */
	public WaitingTransfer() {
		this.animation = new TextAnim(500);
		
		this.panel = new HorizontalPanel();
		this.panel.setWidth("100%");
		this.panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		this.panel.add(this.animation.getLabel());
		initWidget(this.panel);
	}
	
	public WaitingTransfer(int width, int height) {
		this.height = height;
		this.width = width;
		this.animation = new TextAnim(500);
		
		this.panel = new HorizontalPanel();
		this.panel.setWidth(width+"px");
		this.panel.setHeight(height+"px");
		this.panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		this.panel.add(this.animation.getLabel());
		initWidget(this.panel);
	}
	
	/* getter */
	
	public HorizontalPanel getPanel() {
		return panel;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	/* Methods */

	/* to start the animation */
	public void start() {
		this.animation.setActive(true);
		this.run();	
	}

	/* to stop the animation */
	public void stop() {
		this.animation.setActive(false);
		this.animation.cancel();
	}
	
	/* to check if animation is running */
	public boolean isRunning() {
		return this.animation.isRunning();
	}
	
	/* run the animation */
	private void run() {
		if(!this.animation.isRunning())
			this.animation.run(TextWaiting.values().length*((int)this.animation.getPeriodText()));
	}
	
	
	/* Nested class personalized animation */
	private static class TextAnim extends Animation {	
	
		/* Attributes */
		private boolean active;		//animation is active
		private long periodText;	//time period before change text to display	
		private long timeText;		//time to compare with period text
		private long timeFlash;		//time to flash text
		private Label label;		//label to display changing text
		private int countFlash;		//counter to display changing text
		
		final private long periodFlash = 100;
		
		/* Constructor */
		TextAnim(long period){
			super();
			TextAnim.this.active = false; 
			TextAnim.this.periodText = period;
			TextAnim.this.label = new Label();
			TextAnim.this.label.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			TextAnim.this.label.setWidth("100%");
			TextAnim.this.label.setHeight("1em");
			TextAnim.this.label.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			TextAnim.this.label.setVisible(false);
		}
		
		/* getters */
		Label getLabel() {
			return label;
		}
		
		long getPeriodText() {
			return periodText;
		}
		
		/* setter */
		void setActive(boolean active) {
			TextAnim.this.active = active; 			
		}

		/* methods */

	    @Override
	    protected void onStart() {
	    	super.onStart();
			TextAnim.this.label.setVisible(true);
			TextAnim.this.timeText = System.currentTimeMillis();
			TextAnim.this.timeFlash = System.currentTimeMillis();
			TextAnim.this.countFlash = 0;
	    }
	    
		@Override
		protected void onUpdate(double progress) {
			/* check if one animation loop is completed */
			if( System.currentTimeMillis() - TextAnim.this.timeText > 4*TextAnim.this.periodText)
				TextAnim.this.timeText = System.currentTimeMillis();
			
			/* check if one flash period is completed */
			if(System.currentTimeMillis() - TextAnim.this.timeFlash > TextAnim.this.periodFlash) {
				TextAnim.this.timeFlash = System.currentTimeMillis();	
				TextAnim.this.countFlash++;
				
				if(TextAnim.this.countFlash > 3)
					TextAnim.this.countFlash = 0;
				
				if(TextAnim.this.countFlash < 1) {
					TextAnim.this.label.setText("");
				}else {		
					/* display the text corresponding to the time lap */
					if(System.currentTimeMillis() - TextAnim.this.timeText < TextAnim.this.periodText)
						TextAnim.this.label.setText(TextWaiting.FIRST.getText());
					
					else if(System.currentTimeMillis() - TextAnim.this.timeText >= TextAnim.this.periodText && 
							System.currentTimeMillis() - TextAnim.this.timeText < 2*TextAnim.this.periodText)
						TextAnim.this.label.setText(TextWaiting.SECOND.getText());
					
					else if(System.currentTimeMillis() - TextAnim.this.timeText >= 2*TextAnim.this.periodText && 
							System.currentTimeMillis() - TextAnim.this.timeText < 3*TextAnim.this.periodText)
						TextAnim.this.label.setText(TextWaiting.THIRD.getText());
					
					else if(System.currentTimeMillis() - TextAnim.this.timeText >= 3*TextAnim.this.periodText && 
							System.currentTimeMillis() - TextAnim.this.timeText < 4*TextAnim.this.periodText)
						TextAnim.this.label.setText(TextWaiting.FOURTH.getText());
				}
			}
		}
		
		@Override
		protected void onCancel() {
			super.onCancel();
			TextAnim.this.active = false; 	
			TextAnim.this.label.setVisible(false);
	    	TextAnim.this.label.setText("");
			TextAnim.this.timeText = System.currentTimeMillis();
			
		}
		
		@Override
		protected void onComplete() {
			super.onComplete();
			if(TextAnim.this.active)
				TextAnim.this.run(TextWaiting.values().length*((int)TextAnim.this.periodText)); 	
		}
	
	}
	
	/* Nested enum to bind each step of animation */
	private static enum TextWaiting{
		FIRST("Datas uploading ."),
		SECOND("Datas uploading .."),
		THIRD("Datas uploading ..."),
		FOURTH("Datas uploading ....");
		
		String text;
		
		TextWaiting(String text){
			this.text = text;
		}
		
		String getText() {
			return text;
		}
	}

}
