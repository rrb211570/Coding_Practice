// July 23rd, 2021.
class NextOlympics{
   int[] daysPerMonth(boolean leap){
      int[] months = new int[12];
      for(int i=0;i<12;++i){
         if(i==0||i==2||i==4||i==6||i==7||i==9||i==11) months[i] = 31;
         else if(i==1) months[1] = 28 + (leap? 1 : 0);
         else months[i] = 30;
      }
      return months;
   }
   int daysTill_nextYear(int year, int month, int day){
      boolean leap = (year/4==0&&!(year%100==0&&year%400!=0)); // 07/18/2020
      int count = 0;
      int[] months = daysPerMonth(leap);
      count += months[month] - day;
      for(int i=month+1;i<12;++i) count += months[i];
      return count;
   }
   int diffYears_inDays(int year1, int year2){
      int count = 0;
      while(year1<year2){
         boolean leap = (year1/4==0&&!(year1%100==0&&year1%400!=0));
         count += 365 + (leap? 1 : 0);
         year1++;
      }
      return count;
   }
   int daysSince_newYear(int year, int month, int day){
      boolean leap = (year/4==0&&!(year%100==0&&year%400!=0));
      int[] months = daysPerMonth(leap);
      int count = 0;
      for(int i=0;i<month;++i) count += months[i];
      count += day;
      return count;
   }
   int daysBetweenDates(int year, int month1, int day1, int month2, int day2){
      boolean leap = (year/4==0&&!(year%100==0&&year%400!=0));
      int count = 0;
      int[] months = daysPerMonth(leap);
      count += months[month1] - day1;
      for(int i=month1+1;i<month2;++i) count += months[i];
      count += day2;
      return count;
   }
   public int countDays(String today){
      int year = Integer.parseInt(today.substring(0,4));
      int month = Integer.parseInt(today.substring(5,7));
      int day = Integer.parseInt(today.substring(8,10));
      int count = 0;
      if(year<2021) count += daysTill_nextYear(year, month, day) + diffYears_inDays(year+1, 2021) + daysSince_newYear(2021,7,23);
      else count = daysBetweenDates(year, month, day, 7, 23);
      return count;
   }
}
