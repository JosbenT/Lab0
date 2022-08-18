package dataLabs;

public class Lab0P1Wrapper {

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

	public static class VectorComponent implements BaseVector {

		private double X;
		private double Y;

		public VectorComponent(double X, double Y) {
			/*TODO ADD YOUR CODE HERE*/
			this.X = X;
			this.Y = Y;
		}


		@Override
		public double getXComponent() {
			/*TODO ADD YOUR CODE HERE*/
			return X; 
		}

		@Override
		public double getYComponent() {
			/*TODO ADD YOUR CODE HERE*/
			return Y; 
		}

		public void setX(double x) {
			/*TODO ADD YOUR CODE HERE*/
			this.X = x;
		}

		public void setY(double y) {
			/*TODO ADD YOUR CODE HERE*/
			this.Y = y;
		}

		@Override
		public BaseVector add(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			setX(this.X + V.getXComponent());

			setY(this.Y + V.getYComponent());
			
			return V;
			
		}

		@Override
		public BaseVector subtract(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			setX(this.X - V.getXComponent());

			setY(this.Y - V.getYComponent());
			
			return V;
		}

		@Override
		public double dotProduct(BaseVector V) {
			/*TODO ADD YOUR CODE HERE*/
			return this.X*V.getXComponent() + this.Y*V.getYComponent();
		}

		@Override
		public BaseVector crossProduct(BaseVector V) {
			/**
			 * TODO ADD YOUR CODE HERE

			 * Can you do a cross product of 2D vectors?
			 * If not, what should we do?
			 * 
			 * Hint: Look up what UnsopportedOperationException does!
			 */
			return null; //Dummy Return
		}


		@Override
		public double getMagnitude() {
			/*TODO ADD YOUR CODE HERE*/
			return 0.0; //Dummy Return
		}

		@Override
		public double getAngle() {
			/*TODO ADD YOUR CODE HERE*/
			return 0.0; //Dummy Return
		}	
	}
	
	public static void main(String[] args) {
		VectorComponent myVec = new VectorComponent(5, 5);
		VectorComponent myVec2 = new VectorComponent(10, 10);
		
		myVec.add(myVec2);
		System.out.println(myVec.getXComponent() + " " +  myVec.getYComponent());
		
		myVec.subtract(myVec2);
		System.out.println(myVec.getXComponent() + " " +  myVec.getYComponent());

	}
}

