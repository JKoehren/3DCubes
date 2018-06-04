/* UPMC - 2017 / 2018 */
/* Developer: JKoehren */
/* GitHub : https://github.com/JKoehren/3DCubes */
/* Sources:
 * https://www.tutorialspoint.com/jogl/jogl_3d_cube.htm
 * https://www.tutorialspoint.com/awt/awt_mouse_listener.htm
 */

package rotationCube;

import java.awt.*;
import java.awt.event.*;

import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.*;
import com.jogamp.opengl.awt.*;
import com.jogamp.opengl.util.*;


public class Main implements GLEventListener {
	    
    static Cube c1;

    public static void main(String[] args) {
    	
    	GLProfile glp = GLProfile.get(GLProfile.GL2);
        GLCapabilities glca = new GLCapabilities(glp);
        GLCanvas glc = new GLCanvas(glca);
        Frame f = new Frame("Rotation");
        glc.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		System.out.println("Mouse Clicked");
        	}

        	@Override
        	public void mouseEntered(MouseEvent arg0) {
        		System.out.println("Mouse Entered Frame");
        	}
        });
        f.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent we) {
	        	 System.exit(0);
	         }
	    });
        
        glc.addGLEventListener(new Main());
        f.add(glc);
        f.setSize(1200, 740);
        final FPSAnimator animator = new FPSAnimator(glc, 300,true);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable d) {

        GL2 gl = d.getGL().getGL2();

        gl.setSwapInterval(1);

        c1 = new Cube();
        
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
        glu.gluPerspective(45, ratio, 1, 20);
        
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

    }

    public void display(GLAutoDrawable d) {
    	
    	GL2 gl = d.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        c1.display(d);
        
        gl.glFlush();

    }

	@Override
	public void dispose(GLAutoDrawable arg0) {
		
	}
}
