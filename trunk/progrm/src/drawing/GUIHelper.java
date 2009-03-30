package drawing;

import java.awt.Component;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author duj
 *
 * 
 */
public class GUIHelper {
	
	
	
	 private static DisplayMode[] BEST_DISPLAY_MODES = new DisplayMode[] {
		 new DisplayMode(1280, 960, 32, 0),
		 new DisplayMode(1024, 768, 32, 0),
		 new DisplayMode(640, 480, 32, 0),
		 new DisplayMode(640, 480, 16, 0),
		 new DisplayMode(640, 480, 8, 0)
	    };
	 
	 
	 
	public static void showOnFrame(JComponent component, String frameName) {
		JFrame frame = new JFrame(frameName);
		GraphicsDevice device = null;
		if(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length == 2){ //si on a deux éran
			frame.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1].getConfigurations()[1].getBounds().x,GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1].getConfigurations()[1].getBounds().y);
			device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1];
		}
		else 
		{
			frame.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getConfigurations()[0].getBounds().x,GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getConfigurations()[0].getBounds().y);
			device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
		}
		frame.setUndecorated(true);
		frame.setIgnoreRepaint(true);
		
		
		device.setFullScreenWindow(frame);
		if (device.isDisplayChangeSupported()) {
            chooseBestDisplayMode(device);
        }
        
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		
		frame.addWindowListener(wa);
		frame.getContentPane().add(component);
		frame.pack();
		
		//frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
		//
		frame.setDefaultLookAndFeelDecorated(true);
		
		

	}
	
	public static void showOnFrame(Component component, String frameName) {
		Frame frame = new Frame(frameName);
		WindowAdapter wa = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		//        frame.setSize(dim);
		frame.addWindowListener(wa);
		frame.add(component);
		frame.pack();

		frame.setVisible(true);
//		frame.setResizable(false);

	}
	
	
	
	 public static void chooseBestDisplayMode(GraphicsDevice device) {
	        DisplayMode best = getBestDisplayMode(device);
	        if (best != null) {
	            device.setDisplayMode(best);
	        }
	    }
	 
	 
	 private static DisplayMode getBestDisplayMode(GraphicsDevice device) {
	        for (int x = 0; x < BEST_DISPLAY_MODES.length; x++) {
	            DisplayMode[] modes = device.getDisplayModes();
	            for (int i = 0; i < modes.length; i++) {
	                if (modes[i].getWidth() == BEST_DISPLAY_MODES[x].getWidth()
	                   && modes[i].getHeight() == BEST_DISPLAY_MODES[x].getHeight()
	                   && modes[i].getBitDepth() == BEST_DISPLAY_MODES[x].getBitDepth()
	                   ) {
	                    return BEST_DISPLAY_MODES[x];
	                }
	            }
	        }
	        return null;
	    }
	 
	 

}
