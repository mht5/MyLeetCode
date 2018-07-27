package leetcode.string;

/**
 * https://leetcode.com/problems/student-attendance-record-i/description/
 * @author mhts
 * @date 2018Äê7ÔÂ27ÈÕ
 */
public class StudentAttendanceRecord_01 {

	public static void main(String[] args) {
		String str = "PPALLP";
		System.out.println(checkRecord(str));
		System.out.println(checkRecord1(str));
		
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkRecord(str);
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			checkRecord1(str);
		}
		long time3 = System.currentTimeMillis();
		System.out.println(time2 - time1);
		System.out.println(time3 - time2);
	}
	
    public static boolean checkRecord1(String s) {
    	int index = s.indexOf("A");
    	if (index != -1 && s.indexOf("A", ++index) != -1) {
    		return false;
    	}
    	if (s.contains("LLL")) {
    		return false;
    	}
    	return true;
    }
	
    public static boolean checkRecord(String s) {
        boolean absent = false;
        int late = 0;
        for (char ch : s.toCharArray()) {
        	if (ch == 'L') {
        		if (late == 2) {
            		return false;
        		}
        		late++;
        	} else {
        		late = 0;
            	if (ch == 'A') {
            		if (absent) {
                		return false;
            		}
            		absent = true;
            	}
        	}
        }
        return true;
    }

}
