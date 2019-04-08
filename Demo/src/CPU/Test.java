package CPU;

public class Test {
	public static void main(String[] args) {
		CPU cpu =new CPU();
		cpu.setSeepd(2000);
		
		HardDisk disk = new HardDisk();
		disk.setAmount(200);
		
		PC pc =new PC();
		pc.setCPU(cpu);
		pc.setHardDisk(disk);
		pc.show();
	}
}
