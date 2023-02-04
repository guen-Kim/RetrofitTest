package org.techtown.app2.model;

public class BoxOfficeResult
{
    private DailyBoxOfficeList[] dailyBoxOfficeList;

    private String boxofficeType;

    private String showRange;

    public DailyBoxOfficeList[] getDailyBoxOfficeList ()
    {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList (DailyBoxOfficeList[] dailyBoxOfficeList)
    {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }

    public String getBoxofficeType ()
    {
        return boxofficeType;
    }

    public void setBoxofficeType (String boxofficeType)
    {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange ()
    {
        return showRange;
    }

    public void setShowRange (String showRange)
    {
        this.showRange = showRange;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dailyBoxOfficeList = "+dailyBoxOfficeList+", boxofficeType = "+boxofficeType+", showRange = "+showRange+"]";
    }
}
