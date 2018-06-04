/* UPMC - 2017 / 2018 */
/* Developer: JKoehren */
/* GitHub : https://github.com/JKoehren/3DCubes */ 
/* Sources:
 * https://www.tutorialspoint.com/jogl/jogl_3d_cube.htm
 * https://www.tutorialspoint.com/awt/awt_mouse_listener.htm
 */

package rotationCube;

import com.jogamp.opengl.*;

public class Cube {

   private float rquad = 0.0f;
   private float add = -0.5f;
      
   public void display(GLAutoDrawable d) {
	
      final GL2 gl = d.getGL().getGL2();

      gl.glTranslatef(0, 0, -5 ); 

      gl.glRotatef(rquad, 1, 1, 1); 
 
      
      gl.glBegin(GL2.GL_QUADS);
      
      gl.glColor3f(1, 0, 0); 
      gl.glVertex3f(1, 1, -1); 
      gl.glVertex3f(-1, 1, -1);
      gl.glVertex3f(-1, 1, 1); 
      gl.glVertex3f(1, 1, 1);
		
      gl.glColor3f(0, 1, 0);
      gl.glVertex3f(1, -1, 1);
      gl.glVertex3f(-1, -1, 1);
      gl.glVertex3f(-1, -1, -1);
      gl.glVertex3f(1, -1, -1);

      gl.glColor3f(0, 0, 1);
      gl.glVertex3f(1, 1, 1);
      gl.glVertex3f(-1, 1, 1);
      gl.glVertex3f(-1, -1, 1);
      gl.glVertex3f(1, -1, 1);

      gl.glColor3f(1, 1, 0);
      gl.glVertex3f(1, -1, -1);
      gl.glVertex3f(-1, -1, -1);
      gl.glVertex3f(-1, 1, -1);
      gl.glVertex3f(1, 1, -1);

      gl.glColor3f(1, 0, 1);
      gl.glVertex3f(-1, 1, 1);
      gl.glVertex3f(-1, 1, -1);
      gl.glVertex3f(-1, -1, -1);
      gl.glVertex3f(-1, -1, 1);

      gl.glColor3f(0, 1, 1);
      gl.glVertex3f(1, 1, -1);
      gl.glVertex3f(1, 1, 1);
      gl.glVertex3f(1, -1, 1);
      gl.glVertex3f(1 , -1, -1); 
      
      gl.glEnd();
		
      rquad += add;
   }
	
}
