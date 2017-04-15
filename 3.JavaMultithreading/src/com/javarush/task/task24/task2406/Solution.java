package com.javarush.task.task24.task2406;

import java.math.BigDecimal;

/*
РќР°СЃР»РµРґРѕРІР°РЅРёРµ РѕС‚ РІРЅСѓС‚СЂРµРЅРЅРµРіРѕ РєР»Р°СЃСЃР°
Р’РЅСѓС‚СЂРё РєР»Р°СЃСЃР° Solution СЃРѕР·РґР°Р№ 2 РІРЅСѓС‚СЂРµРЅРЅРёС… public РєР»Р°СЃСЃР° Apt3Bedroom, BigHall.
РЈРЅР°СЃР»РµРґСѓР№ РёС… РѕС‚ Apartments Рё Hall.


*/
public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }


    public class Apt3Bedroom extends Building.Apartments{
        public Apt3Bedroom(Building building) {
            building.super();
        }
    }
    public class BigHall extends Building.Hall{

        public BigHall(Building building, BigDecimal square) {
            building.super(square);


        }
    }



    public static void main(String[] args) {

    }
}

