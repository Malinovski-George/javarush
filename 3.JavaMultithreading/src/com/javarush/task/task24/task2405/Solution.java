package com.javarush.task.task24.task2405;

/*
Black box
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! РР·РјРµРЅРµРЅРёСЏ РјРѕРіСѓС‚ Р±С‹С‚СЊ С‚СѓС‚


        public void someAction() {
            if (param > 0) {
                for (int i = param; param > 0; param--) {
                    System.out.println(param);
                }
                //!!!!! All changes have to be here
                //!!!!! Р’СЃРµ РёР·РјРµРЅРµРЅРёСЏ РґРѕР»Р¶РЅС‹ Р±С‹С‚СЊ С‚РѕР»СЊРєРѕ С‚СѓС‚
                FirstClass firstClass = new FirstClass()
                {
                    @Override
                    public Action getDependantAction()
                    {
                        super.someAction();
                        return new Action(){
                            @Override
                            public void someAction()
                            {
                            }
                        };
                    }
                };
               firstClass.someAction();
            }
            SecondClass second = new SecondClass();
            second.someAction();
            System.out.println(second.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1) + param);
        }


    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();

    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

    }
}
