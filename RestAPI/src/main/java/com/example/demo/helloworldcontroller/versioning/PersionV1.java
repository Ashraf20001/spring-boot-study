package com.example.demo.helloworldcontroller.versioning;

public class PersionV1 {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public PersionV1(String name) {
			super();
			this.name = name;
		}

		@Override
		public String toString() {
			return "PersionV1 [name=" + name + "]";
		}
		
		
}
