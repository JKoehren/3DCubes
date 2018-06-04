/* UPMC - 2017 / 2018 */
/* Developer: JKoehren */
/* GitHub : https://github.com/JKoehren/3DCubes */ 
/* Sources:
 * https://www.tutorialspoint.com/jogl/jogl_3d_cube.htm
 * https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
 */

package rotationCube;

import java.util.Random;

import com.jogamp.opengl.*;

public class Cube {

   private float rotation = 0.0f;
   private float vitesse = -0.5f;
   private float position = 0;
   private float size = 1;
   private int[][] color = {
		   {0,0,1},
		   {0,1,0},
		   {0,1,1},
		   {1,0,0},
		   {1,0,1},
		   {1,1,0},
		   {1,1,1}
   };
      
   public void display(GLAutoDrawable d) {
	
      final GL2 gl = d.getGL().getGL2();

      gl.glTranslatef(position, position, -5 ); 

      gl.glRotatef(rotation, 1, 1, 1);
 
      
      gl.glBegin(GL2.GL_QUADS);
      
      int face = 0;
      
      gl.glColor3f(color[face][0], color[face][1], color[face][2]); 
      gl.glVertex3f(size, size, -size); 
      gl.glVertex3f(-size, size, -size);
      gl.glVertex3f(-size, size, size); 
      gl.glVertex3f(size, size, size);
      
      face++;
		
      gl.glColor3f(color[face][0], color[face][1], color[face][2]); 
      gl.glVertex3f(size, -size, size);
      gl.glVertex3f(-size, -size, size);
      gl.glVertex3f(-size, -size, -size);
      gl.glVertex3f(size, -size, -size);
      
      face++;

      gl.glColor3f(color[face][0], color[face][1], color[face][2]);  
      gl.glVertex3f(size, size, size);
      gl.glVertex3f(-size, size, size);
      gl.glVertex3f(-size, -size, size);
      gl.glVertex3f(size, -size, size);
      
      face++;

      gl.glColor3f(color[face][0], color[face][1], color[face][2]);  
      gl.glVertex3f(size, -size, -size);
      gl.glVertex3f(-size, -size, -size);
      gl.glVertex3f(-size, size, -size);
      gl.glVertex3f(size, size, -size);
      
      face++;

      gl.glColor3f(color[face][0], color[face][1], color[face][2]); 
      gl.glVertex3f(-size, size, size);
      gl.glVertex3f(-size, size, -size);
      gl.glVertex3f(-size, -size, -size);
      gl.glVertex3f(-size, -size, size);
      
      face++;

      gl.glColor3f(color[face][0], color[face][1], color[face][2]); 
      gl.glVertex3f(size, size, -size);
      gl.glVertex3f(size, size, size);
      gl.glVertex3f(size, -size, size);
      gl.glVertex3f(size , -size, -size); 
      
      gl.glEnd();
		
      rotation += vitesse;
   }
   
   public void setPos(float pos) {
	   this.position = pos;
   }
   public void setVit(float vit) {
	   this.vitesse = vit;
   } 
   public void setSize(float s) {
	   this.size = s;
   } 
   public void eventChange() {
	   this.vitesse = this.vitesse * (float) -1;
	   this.shuffleColor();
   }
   
   private void shuffleColor() {
       int index;
       int[] temp;
       Random random = new Random();
       for (int i = this.color.length - 1; i > 0; i--) {
           index = random.nextInt(i + 1);
           temp = this.color[index];
           this.color[index] = this.color[i];
           this.color[i] = temp;
       }
   }
	
}
