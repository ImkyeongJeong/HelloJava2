
public class ArrayExam {

	public static void main(String[] args) {
		String[] arr = {"010102-4", "991012-1", "960304-1", "881012-2", "040403-3" };
		
		int m = 0;
		int w = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].substring(7,8).equals("1") || arr[i].substring(7,8).equals("3")) {
				m = m + 1;
			} else if(arr[i].substring(7,8).equals("2") || arr[i].substring(7,8).equals("4")) {
				w = w + 1;
			}
		}
		System.out.println("남 " + m + " 여 " + w);
	}

}


