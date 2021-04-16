package common;

public class ScreenFactory {

    private ScreenFactory(){

    }
    public static <TPage>TPage get(Class<TPage> classPage){
        TPage page = null;
        try {
            page = classPage.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return page;
    }

}
