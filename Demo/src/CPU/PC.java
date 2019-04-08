package CPU;

public class PC {
	CPU cpu;
	HardDisk HD;
	public void setCPU(CPU c) {
		this.cpu = c;
	}
	
	public void setHardDisk(HardDisk h) {
		HD = h;
	}
	
	public void show() {
		System.out.println("cpu: " +cpu.getSeepd());
		System.out.println("Hd: "+HD.getAmount());
	}

	
}
