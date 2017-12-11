package com.nuclearpencil.hj.fitbash.data.enums;

public enum sliderMenuItems {


    Main("Main", 0), // Calling  sliderMenuItems(String toString, int value)
    ListAllGroup("ListAllGroup", 1),
    Bestsellers("Bestsellers", 2),
    Favorites("Favorites", 3),
    Newest("Newest", 4),
    About("About", 5);


    public String stringValue; // for use return text e g : sliderMenuItems.Main.stringValue    return 'Main'
    public int id;

    sliderMenuItems(String toString, int value) {
        stringValue = toString;
        id = value;
    }


    @Override
    public String toString() {
        return stringValue;
    }

}


enum Gender {
    MALE,
    FEMALE
}


    /*

    public enum Transformer {

        Default("Default"),
        Accordion("Accordion"),
        Background2Foreground("Background2Foreground"),
        CubeIn("CubeIn"),
        DepthPage("DepthPage"),
        Fade("Fade"),
        FlipHorizontal("FlipHorizontal"),
        FlipPage("FlipPage"),
        Foreground2Background("Foreground2Background"),
        RotateDown("RotateDown"),
        RotateUp("RotateUp"),
        Stack("Stack"),
        Tablet("Tablet"),
        ZoomIn("ZoomIn"),
        ZoomOutSlide("ZoomOutSlide"),
        ZoomOut("ZoomOut");

        private final String name;

        private Transformer(String s){
            name = s;
        }
        public String toString(){
            return name;
        }

        public boolean equals(String other){
            return (other == null)? false:name.equals(other);
        }






        // Use

        public void setPresetTransformer(int transformerId){
                for(Transformer t : Transformer.values()){
                    if(t.ordinal() == transformerId){
                        setPresetTransformer(t);
                        break;
                    }
                }
            }


        public void setPresetTransformer(String transformerName){
            for(Transformer t : Transformer.values()){
                if(t.equals(transformerName)){
                    setPresetTransformer(t);
                    return;
                }
            }
        }

        public void setPresetTransformer(Transformer ts){
            //
            // special thanks to https://github.com/ToxicBakery/ViewPagerTransforms
            //
            BaseTransformer t = null;
            switch (ts){
                case Default:
                    t = new DefaultTransformer();
                    break;
                case Accordion:
                    t = new AccordionTransformer();
                    break;
                case Background2Foreground:
                    t = new BackgroundToForegroundTransformer();
                    break;
                case CubeIn:
                    t = new CubeInTransformer();
                    break;
                case DepthPage:
                    t = new DepthPageTransformer();
                    break;
                case Fade:
                    t = new FadeTransformer();
                    break;
                case FlipHorizontal:
                    t = new FlipHorizontalTransformer();
                    break;
                case FlipPage:
                    t = new FlipPageViewTransformer();
                    break;
                case Foreground2Background:
                    t = new ForegroundToBackgroundTransformer();
                    break;
                case RotateDown:
                    t = new RotateDownTransformer();
                    break;
                case RotateUp:
                    t = new RotateUpTransformer();
                    break;
                case Stack:
                    t = new StackTransformer();
                    break;
                case Tablet:
                    t = new TabletTransformer();
                    break;
                case ZoomIn:
                    t = new ZoomInTransformer();
                    break;
                case ZoomOutSlide:
                    t = new ZoomOutSlideTransformer();
                    break;
                case ZoomOut:
                    t = new ZoomOutTransformer();
                    break;
            }
            setPagerTransformer(true,t);
        }


    };
*/


enum MyType {

    Main {
        @Override
        public String toString() {
            return "this is one";
        }
    },
    ListAllGroup {
        public String toString() {
            return "this is one";
        }
    },
    Bestsellers {
        public String toString() {
            return "this is one";
        }
    },

    Favorites {
        public String toString() {
            return "this is one";
        }
    },

    Newest {
        public String toString() {
            return "this is one";
        }
    },
    About {
        public String toString() {
            return "this is two";
        }
    }




/*

http://appinapps.com/Articles_View.aspx?t=%D8%B3%D8%A7%D8%AE%D8%AA%D9%85%D8%A7%D9%86%20%D8%AF%D8%A7%D8%AF%D9%87%20%D9%87%D8%A7%20%D8%AF%D8%B1%20%D8%AC%D8%A7%D9%88%D8%A7%20(Enums)%20%D9%85%D8%AC%D9%85%D9%88%D8%B9%D9%87%20%D8%B4%D9%85%D8%A7%D8%B1%D8%B4%DB%8C&gid=14&aid=180


public enum MyColors {
    RED,
    GREEN,
    BLUE
}


// Use :

//????? ? ????? ???
MyColors mycolors = MyColors.RED

if( mycolors == MyColors.RED) {
        //?? ???
        } else if( mycolors == MyColors.GREEN) {
        //?? ???
        } else if( mycolors == MyColors.BLUE) {
        //?? ???
        }

//?????? ? ??? ????? ??????
        for (MyColors mycolor : MyColors.values()) {
        System.out.println(mycolor);
        }


*/





/*
public enum MyColors {
    RED (3), //?????? ??? 3 ?? ??? ????
    GREEN(2),
    BLUE (1)
    ; // ???? ??????? ?????? ??? ?????? ???? ??? ?? ??? ?????? ?? ????????? ??????

    //?? ?????? ??? ?? enum
    private final int myColorsNUM;

    //?????? ?????? ??????
    MyColors(int color) {
        this.myColorsNUM = color;
    }

    //???? ???? ????? ?? ????? ?? ????? ?????? ???
    public int getColorCode() {
        return this.myColorsNUM;
    }

}


// Use :

MyColors mycolors= MyColors.RED;

System.out.println(mycolors.getColorCode());


*/


}