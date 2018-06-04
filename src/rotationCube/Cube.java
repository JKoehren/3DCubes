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
   private float angle = 0;
   private float posX = 0;
   private float posY = 0;
   private int orbit = 0;
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
	   
	  if (angle == 360 || angle == -360) angle = 0;
	  if (orbit == 3) orbit = 1;
	  
	  
	
      final GL2 gl = d.getGL().getGL2();
      
      gl.glTranslatef((float) Math.cos(Math.toRadians(angle)) * position + posX, (float) Math.sin(Math.toRadians(angle)) * position + posY, -5 ); 
      

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
      
      if (orbit == 1) {
    	  angle++;
      } else {
    	  angle--;
      }
      
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
   public void orbit() {
	   this.orbit++;
   } 
   public void eventChange() {
	   this.vitesse = this.vitesse * (float) -1;
	   this.shuffleColor();
	   this.orbit();
   }
   public void shuffleColor() {
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
   public void setAnotherPos(Cube c) {
	   this.posX = c.getX();
	   this.posY = c.getY();
   }
   public float getX() {
	   return ((float) Math.cos(Math.toRadians(angle)) * position + posX);
   }
   public float getY() {
	   return ((float) Math.sin(Math.toRadians(angle)) * position + posY);
   }
	
}
