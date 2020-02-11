import java.util.*;
public class WeekPlansApp{
	public static void main(String[] args){
		int days=7;
		Scanner sc=new Scanner(System.in);
				Day[] week=new Day[days];

		while(true){
			System.out.println("***今週の予定***");
			System.out.print("1.予定を入力: 2.終了 >");
			int selectNum=sc.nextInt();
			if(selectNum==1){

				week[0]=new Day("Mon"); 
				week[1]=new Day("Tue"); 
				week[2]=new Day("Wed"); 
				week[3]=new Day("Thu"); 
				week[4]=new Day("Fri"); 
				week[5]=new Day("Sat"); 
				week[6]=new Day("Sun"); 

				for(int i=0;i<week.length;i++){
					System.out.println();
					System.out.print(" "+week[i].day+"の予定は?  1.授業: 2.休み >");
					int selectPlan=sc.nextInt();
					System.out.print(" メモを入力→ ");sc.nextLine();
					String memo=sc.nextLine();
					Day day=new Day(week[i].day,selectPlan,memo);
					week[i]=day;
					days--;
				}
			}else{
				return;
			}
			if(days==0){
				break;
			}
		}
//		
		while(true){
			System.out.print("1.予定表示: 2.予定を変更: 3.終了 >");
			int selectNum2=sc.nextInt();
			switch(selectNum2){
				case 1:
					showSelect(week);
					break;
				case 2:
					changePlan(week);
					break;
				case 3:
					return;
			}
		}
		}
		public static void showSelect(Day[] week){
			System.out.print("0.全予定表示: 1.授業のみ表示: 2.休みのみ表示: 3.未定のみ表示: 4.戻る >");
			int showSelectNum=new Scanner(System.in).nextInt();
			if(showSelectNum==4){
				return;
			}else{
				Day.selectPrint(week,showSelectNum);
			}
		}
		public static void changePlan(Day[] week){
			Scanner sc=new Scanner(System.in);
			Day[] tempArr=new Day[week.length];
			for(int i=0;i<tempArr.length;i++){
				Day temp=week[i];
				tempArr[i]=temp;
				System.out.print((i+1)+".");
				Day.selectPrint(tempArr,0);
			}
			while(true){
				System.out.print("変更する番号を選択 (0で変更終了)>");
				int changeNum=sc.nextInt();
				if(changeNum==0){
					return;
				}
					for(int i=0;i<week.length;i++){
							week[i]=tempArr[i];
					}
					System.out.print(" "+tempArr[changeNum-1].day+"の予定は?  1.授業: 2.休み >");

					int cPlan=sc.nextInt();
					System.out.print(" メモを入力→ ");sc.nextLine();
					String Cmemo=sc.nextLine();
					tempArr[changeNum-1].plan=cPlan;
					tempArr[changeNum-1].memo=Cmemo;
			}
	}
}

//
class Day{
	String day;
	int plan;
	String memo;

	Day(String day){
		this.day=day;
	}
	Day(String day,int plan,String memo){
		this(day);
		this.plan=plan;
		this.memo=memo;
	}
	public static void selectPrint(Day[] week,int selectNum){
			switch(selectNum){
				case 0:
					System.out.println("今週の予定一覧");
					for(Day n:week){
						if(n.plan==1){
						showPlan(n.day,"授業",n.memo);
						}else if(n.plan==2){
						showPlan(n.day,"休み",n.memo);
						}else{
						showPlan(n.day,"未定",n.memo);
						}
					}
					break;
				case 1:
					System.out.println("授業の日一覧");
					for(Day n:week){
						if(n.plan==1){
						showPlan(n.day,"授業",n.memo);
						}
					}
					break;
				case 2:
					System.out.println("休みの日一覧");
					for(Day n:week){
						if(n.plan==2){
						showPlan(n.day,"休み",n.memo);
						}
					}
					break;
				case 3:
					System.out.println("未定の日一覧");
					for(Day n:week){
						if(n.plan!=1 && n.plan!=2){
						showPlan(n.day,"未定",n.memo);
						}
					}
					break;
			}
	}
	public static void showPlan(String n,String s,String m){
		System.out.printf("%sの予定は%s",n,s);
		System.out.println("	メモ: "+m);
		System.out.println();
	}
}
