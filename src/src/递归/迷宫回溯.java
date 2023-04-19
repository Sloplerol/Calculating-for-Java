package 递归;

public class 迷宫回溯 {
    public static void main(String[] args) {
        //构建一个87的迷宫
        int[][] map = new int[8][7];
        for(int i = 0;i < 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for(int i = 0;i < 7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;

        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("新构建出来的地图");
        //输入新的地图
        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map,int i,int j){
        /*
        0点代表没有走过 1代表墙 2代表通路可以走 3代表死路
         */
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map,i - 1,j)){
                    //向下走
                    return true;
                }else if(setWay(map,i,j + 1)){
                    return true;
                    //向右走
                }else if(setWay(map,i + 1,j)){
                    //向上走
                    return true;
                }else if(setWay(map,i,j - 1)){
                    //向左走
                    return true;
                }else {
                    //死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
