package dataLabs;

public class Lab0P2Wrapper {

	public static interface BaseVector {
		public double getXComponent();
		public double getYComponent();
		public double getMagnitude();
		public double getAngle();
		public BaseVector add(BaseVector V);
		public BaseVector subtract(BaseVector V);
		public double dotProduct(BaseVector V);
		public BaseVector crossProduct(BaseVector V);
	}
	
	public static class VectorMagnitude implements BaseVector {
		
		public double magnitude; // The magnitude of the vector
		public double angle; // The angle of the vector, in degrees
		
		public VectorMagnitude(double magnitude, double angle) {
			/*TODO ADD YOUR CODE HERE*/
			this.magnitude = magnitude;
			this.angle = angle;
		}

		@Override
		public double getMagnitude() {
			/*TODO ADD YOUR CODE HERE*/
			return this.magnitude;
		}

		public void setMagnitude(double magnitude) {
			/*TODO ADD YOUR CODE HERE*/
			this.magnitude = magnitude;
		}

		@Override
		public double getAngle() {
			/*TODO ADD YOUR CODE HERE*/
			return this.angle;
		}

		public void setAngle(double angle) {
			/*TODO ADD YOUR CODE HERE*/
			this.angle = angle;
		}
		
		@Override
		public double getXComponent() {
			/*TODO ADD YOUR CODE HERE*/
			return Math.round(Math.cos(Math.toRadians(this.angle))*this.magnitude);
		}

		@Override
		public double getYComponent() {
			/*TODO ADD YOUR CODE HERE*/
			return Math.sin(Math.toRadians(this.angle))*this.magnitude;
		}


		@Override
		public BaseVector add(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			double x = this.getXComponent() + V.getXComponent();
			double y = this.getYComponent() + V.getYComponent();
			
			return new VectorMagnitude(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)), Math.toDegrees(Math.atan(y/x)));
		}

		@Override
		public BaseVector subtract(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			double x = this.getXComponent() - V.getXComponent();
			double y = this.getYComponent() - V.getYComponent();
			
			return new VectorMagnitude(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)), Math.toDegrees(Math.atan(y/x)));
		}

		@Override
		public double dotProduct(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			return this.getXComponent()*V.getXComponent() + this.getYComponent()*V.getYComponent();
		}

		@Override
		public BaseVector crossProduct(BaseVector V) {
			/**
			 * Can you do a cross product of 2D vectors?
			 * If not, what should we do?
			 * 
			 * Hint: Look up what UnsopportedOperationException does!
			 */
			return null; //Dummy return
		}
	}
	
	public static void main(String[] argsd) {
		VectorMagnitude myVec = new VectorMagnitude(7.0710678118654755, 45);
		VectorMagnitude myVec2 = new VectorMagnitude(14.142135623730951, 45);

		
//		System.out.println(myVec.getAngle());
//		System.out.println(myVec.getMagnitude());
		
		System.out.println(myVec.getXComponent());
		System.out.println(myVec.getYComponent());
		
		VectorMagnitude myVec3 = new VectorMagnitude(myVec.add(myVec2).getXComponent(), myVec.add(myVec2).getYComponent());

		System.out.println(myVec3.getXComponent() + " " + myVec3.getYComponent());

//		System.out.println(myVec2.getXComponent());
//		System.out.println(myVec2.getYComponent());

		
	}
}