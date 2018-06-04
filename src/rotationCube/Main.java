/* UPMC - 2017 / 2018 */
/* Developer: JKoehren */
/* GitHub : https://github.com/JKoehren/3DCubes */
/* Sources:
 * https://www.tutorialspoint.com/jogl/jogl_3d_cube.htm
 * https://www.tutorialspoint.com/awt/awt_mouse_listener.htm
 */

package rotationCube;

import java.awt.event.*;

import javax.swing.JFrame;

import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.*;
import com.jogamp.opengl.awt.*;
import com.jogamp.opengl.util.*;


public class Main implements GLEventListener {
	    
    static Cube c1;
    static Cube c2;
    static Cube c3;

    public static void main(String[] args) {
    	
    	System.err.close();
        System.setErr(System.out);   	
    	
    	GLProfile glp = GLProfile.get(GLProfile.GL2);
        GLCapabilities glca = new GLCapabilities(glp);
        
        GLCanvas glc = new GLCanvas(glca);
        c1 = new Cube();
        c1.setSize(1.5f);
        c1.shuffleColor();
        
        c2 = new Cube();
        c2.setPos(9f);
        c2.setVit(0.5f);
        c2.orbit();
        c2.shuffleColor();
        
        c3 = new Cube();
        c2.setSize(0.4f);
        c3.setVit(2f);
        c3.setPos(4f);
        c3.orbit();
        c3.orbit();
        c3.shuffleColor();
        
       
        glc.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		System.out.println("Mouse Clicked");
        		c1.eventChange();
        		c2.eventChange();
        		c3.eventChange();
        	}

        	@Override
        	public void mouseEntered(MouseEvent arg0) {
        		System.out.println("Mouse Entered Frame");
        		c1.eventChange();
        		c2.eventChange();
        		c3.eventChange();
        	}
        });
        glc.addGLEventListener(new Main());
        
        final JFrame f = new JFrame("Rotation");
        f.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent we) {
	        	 System.exit(0);
	         }
	    });
        
        f.getContentPane().add(glc);
        
        f.setSize(1200, 800);
        f.setVisible(true);
        
        final FPSAnimator animator = new FPSAnimator(glc, 300,true);
        
        animator.start();
    }

    public void init(GLAutoDrawable d) {

        GL2 gl = d.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 0);
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
        gl.glClearDepth(1);
        
    }

    public void reshape(GLAutoDrawable d, int x, int y, int w, int h) {
        
    	GL2 gl = d.getGL().getGL2();
        
        if (h <= 0) h = 1;
        
        float ratio = (float) w / (float) h;
        
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        
        GLU glu = new GLU();
        glu.gluPerspective(130, ratio, 1, 20);
        
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

    }

    public void display(GLAutoDrawable d) {
    	
    	GL2 gl = d.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        c1.display(d);
        gl.glLoadIdentity();
        c2.display(d);
        gl.glLoadIdentity();
        c3.setAnotherPos(c2);
        c3.display(d);
        gl.glFlush();

    }

	@Override
	public void dispose(GLAutoDrawable arg0) {
		
	}
}
