package sampleTest3;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1 {

	/*
	 * コードの内容
	 * コンソールに入力した年月と前後のカレンダーを表示する
	 *
	 */
	public static void main(String args[]) {
		int year = 0;
		int month = 0;

		// 西暦を入力
		// 正しい数値が入力されるまで入力を繰り返す
		System.out.println("表示したい年を西暦で入力してください");
		while (true){
			try {
				year = new Scanner(System.in).nextInt();
				if (year > 0) {
					break;
				}
				System.out.println("西暦を正の整数で入力してください");

			} catch (InputMismatchException e) {
				System.out.println("西暦を数値で入力してください");
			}
		}

		// 月を入力
		// 正しい数値が入力されるまで入力を繰り返す
		System.out.println("表示したい月を入力してください");
		while (true){
			try {
				month = new Scanner(System.in).nextInt();
				if (!(month < 1 || month > 12)) {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("月を数値で入力してください");
			}
		}

		// カレンダーに表示する曜日を変数に用意
		String[] weekday = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

		// 入力された前月を表示
		// 入力された数が1月ならその前の年の12月を表示
		if (month == 1) {
			System.out.println(year +"年" + ":"  + "12月");
		} else {
		System.out.println(year + "年" + ":" + (month - 1) + "月");
		}

		// 曜日を右寄せに表示
		for(String s : weekday) {
			System.out.printf("%4s", s);
		}
		System.out.println();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 2));
		cal.set(Calendar.DATE, 1);
		// その月の最終日を取得
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 1日の曜日を取得
		int startIndex = cal.get(Calendar.DAY_OF_WEEK);

		// 1日の曜日までスペースを表示
		for (int i = 1; i < startIndex; i++) {
			System.out.printf("%4s", "");
		}

		// 右寄せで日付を表示
		// 土曜日の日付の場合は改行
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			cal.set(Calendar.DATE, i);
			if(Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)) {
				System.out.println("");
			}
		}
		System.out.println("\n");

		// 入力された月を表示
		System.out.println(year +"年" + ":" + month + "月");
		// 曜日を右寄せに表示
		for(String s : weekday) {
			System.out.printf("%4s", s);
		}
		System.out.println();

		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DATE, 1);

		// その月の最終日を取得
		maxDay =cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 1日の曜日を取得
		startIndex = cal.get(Calendar.DAY_OF_WEEK);

		// 1日の曜日までスペースを表示
		for (int i = 1; i < startIndex; i++) {
			System.out.printf("%4s", "");
		}

		// 右寄せで日付を表示
		// 土曜日の日付の場合は改行
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			cal.set(Calendar.DATE, i);
			if (Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)) {
				System.out.println("");
			}
		}

		System.out.println("\n");

		// 入力された翌月を表示
		// 入力された数が12月なら次の年の1月を表示
		if (month == 12) {
			System.out.println(year +"年" + ":" + "1月");
		} else {
			System.out.println(year +"年" + ":" + (month + 1) + "月");
		}

		// 曜日を右寄せに表示
		for(String s : weekday) {
			System.out.printf("%4s", s);
		}
		System.out.println();

		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1);

		// その月の最終日を取得
		maxDay =cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 1日の曜日を取得を取得
		startIndex = cal.get(Calendar.DAY_OF_WEEK);

		// 1日の曜日までスペースを表示
		for (int i = 1; i < startIndex; i++) {
			System.out.printf("%4s", "");
		}

		// 右寄せで日付を表示
		// 土曜日の日付の場合は改行
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			cal.set(Calendar.DATE, i);
			if (Calendar.SATURDAY == cal.get(Calendar.DAY_OF_WEEK)) {
				System.out.println("");
			}
		}
		System.out.println("\n");
	}
}