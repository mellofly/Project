package com.it.thread;

/**
 *          氓（诗经）
 *    氓之蚩蚩，抱布贸丝，匪来贸丝，来即我谋。送子涉淇，至于顿丘。匪我愆期，子无良媒。将子无怒，秋以为期。
 *    乘彼垝垣，以望复关，不见复关，泣涕涟涟。既见复关，载笑载言。尔卜尔筮，体无咎言。以尔车来，以我贿迁。
 *    桑之未落，其叶沃若。于嗟鸠兮，无食桑葚。于嗟女兮，无与士耽。士之耽兮，尤可脱也。女之耽兮，不可说也。
 *    桑之落矣，其黄而陨。自我徂尔，三岁食贫。淇水汤汤，渐车帷裳。女也不爽，士贰其行。士也罔极，二三其德。
 *    三岁为妇，靡室劳矣，夙兴夜寐，靡有朝矣。言既遂矣，至于暴矣。兄弟不知，咥其笑矣，静言思之，躬自悼矣。
 *    及尔偕老，老使我怨。淇则有岸，隰则有泮。总角之宴，言笑晏晏。信誓旦旦，不思其反。反是不思，亦已焉哉。
 *
 *
 *    需要执行的操作。
 */
public class MyTask implements  Runnable{
    protected  int index;
    public MyTask(int i){
        this.index=i;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---"+index);
        try{
            Thread.sleep(1000l);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
