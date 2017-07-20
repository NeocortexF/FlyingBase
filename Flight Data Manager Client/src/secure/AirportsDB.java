package secure;

import javax.swing.table.DefaultTableModel;

public class AirportsDB {

    public DefaultTableModel getData() {
        DefaultTableModel dm = new DefaultTableModel();

        dm.addColumn("Название");
        dm.addColumn("Код ИКАО");

        String[] airportsName = {"Алматы", "Анапа", "Байконур", "Баку", "Барнаул", "Бишкек", "Владивосток",
                "Волгоград", "Габала", "Геленджик", "Гюмри", "Гянджа", "Душанбе", "Екатеринбург", "Ереван",
                "Иркутск", "Казань", "Калининград", "Киев(Борисполь)", "Киев(Жуляны)", "Краснодар", "Красноярск",
                "Куляб", "Кутаиси", "Ленкорань", "Мин.Воды", "Москва (Внуково)", "Москва (Домодедово)", "Москва (Шереметьево)",
                "Н.Новгород", "Надым", "Наманган", "Нижневартовск", "Нижнекамск", "Новокузнецк", "Новосибирск",
                "Новый Уренгой", "Норильск", "Ноябрьск", "Нукус", "Ош", "Пермь", "Ростов", "Самара", "Самарканд",
                "Санкт-Петербург", "Симферополь", "Сочи", "Сургут", "Ташкент", "Тбилиси", "Уфа", "Хабаровск",
                "Ханты-Мансийск", "Худжант", "Челябинск", "Чита", "Якутск", "Ямбург", "Ярославль", "АНТАЛЬЯ",
                "БАНГКОК", "БАРСЕЛОНА", "БУДАПЕШТ", "БУРГАС", "БУРСА (ЕНИШЕХИР)", "ВЕРОНА", "ГУАНЧЖОУ", "ДЖИДДА",
                "ДУБАЙ", "ЗАЛЬЦБУРГ", "КАРЛОВЫ-ВАРЫ", "КЕЛЬН(БОНН)", "ЛАРНАКА", "МЕДИНА", "МЮНХЕН", "НЕАПОЛЬ",
                "ОСЛО(ГАРДЕРМОЕН)", "ПАЛЬМА ДЕ МАЙОРКА", "ПАРИЖ(ШАРЛЬ ДЕ ГОЛЛЬ)", "ПАФОС", "ПРАГА", "ПУЛА",
                "РИМ(ФЬЮМИЧИНО)", "РИМИНИ", "РОДОС", "САЛОНИКИ", "ТЕЛЬ-АВИВ(БЕН ГУРИОН)", "ТИВАТ", "ТРИЕСТ",
                "ТЮМЕНЬ(РОЩИНО)", "ХУРГАДА", "ШАРМ-ЭЛЬ-ШЕЙХ"};
        String[] airportsCode = {"UAAA", "URKA", "UAOL", "UBBB", "UNBB", "UCFM", "UHWW", "URWW", "UBBQ", "URKG",
                "UDSG", "UBBG", "UTDD", "USSS", "UDYZ", "UIII", "UWKD", "UMKK", "UKBB", "UKKK", "URKK", "UNKL", "UTDK",
                "UGKO", "UBBL", "URMM", "UUWW", "UUDD", "UUEE", "UWGG", "USMM", "UTFN", "USNN", "UWKE", "UNWW",
                "UNNT", "USMU", "UOOO", "USRO", "UTNN", "UCFO", "USPP", "URRR", "UWWW", "UTSS", "ULLI", "URFF",
                "URSS", "USRR", "UTTT", "UGTB", "UWUU", "UHHH", "USHH", "UTDL", "USCC", "UIAA", "UEEE", "USMQ",
                "UUDL", "LTAI", "VTBS", "LEBL", "LHBP", "LBBG", "LTBR", "LIPX", "ZGGG", "OEJN", "OMDB", "LOWS",
                "LKKV", "EDDK", "LCLK", "OEMA", "EDDM", "LIRN", "ENGM", "LEPA", "LFPG", "LCPH", "LKPR", "LDPL",
                "LIRF", "LIPR", "LGRP", "LGTS", "LLBG", "LYTV", "LIPQ", "USTR", "HEGN", "HESH"};

        for (int i = 0; i < airportsCode.length; i++) {
            String stringFirstRow = airportsName[i];
            String stringSecondRow = airportsCode[i];
            dm.addRow(new String[]{airportsName[i], airportsCode[i]});
        }
        return dm;
    }
}
