package com.alherd.greatpeopleapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clinicBase.db";

    /**
     * Таблица GREAT_PEOPLE
     */
    public static final String TABLE_PEOPLE = "people";
    public static final String COLUMN_ID_PEOPLE = "_id_people";
    public static final String COLUMN_PROFESSION_PEOPLE = "profession_people";
    public static final String COLUMN_CONCRETE_PROFY_PEOPLE = "concrete_profy_people";
    public static final String COLUMN_NAME_PEOPLE = "name_people";
    public static final String COLUMN_PHOTO_PEOPLE = "photo_people";
    public static final String COLUMN_DESCRIPTION_PEOPLE = "description_people";

    public static final String NAME_MAN = "NAME";
    public static final String PROFESSION = "profession";
    public static final String PROFESSION_WRITER = "writer";
    public static final String PROFESSION_ARTIST = "artist";
    public static final String PROFESSION_SCIENTIST = "scientist";
    public static final String PROFESSION_SPORTSMAN = "sportsman";
    public static final String PROFESSION_POLITICIAN = "politician";
    public static final String PROFESSION_SINGER = "singer";
    public static final String CONCRETE_PROFESSION_WRITER_POET = "Поэзия";
    public static final String CONCRETE_PROFESSION_WRITER_PROSE = "Проза";
    public static final String CONCRETE_PROFESSION_ARTIST_ABSTRACTIONISM = "Абстракционизм";
    public static final String CONCRETE_PROFESSION_ARTIST_AVANT_GARDISM = "Авангардизм";
    public static final String CONCRETE_PROFESSION_SCIENTIST_MATHEMATICIAN = "Математика";
    public static final String CONCRETE_PROFESSION_SCIENTIST_PHYSICIAN = "Физика";
    public static final String CONCRETE_PROFESSION_SPORTSMAN_FOOTBALL = "Футбол";
    public static final String CONCRETE_PROFESSION_SPORTSMAN_HOCKEY = "Хоккей";
    public static final String CONCRETE_PROFESSION_POLITICIAN_PRESIDENT = "Президент";
    public static final String CONCRETE_PROFESSION_POLITICIAN_REVOLUTIONER = "Революционер";
    public static final String CONCRETE_PROFESSION_POLITICIAN_KING = "Король";
    public static final String CONCRETE_PROFESSION_SINGER_GROUP = "Группа";
    public static final String CONCRETE_PROFESSION_SINGER_SOLO = "Соло";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PEOPLE
                + " (" + COLUMN_ID_PEOPLE
                + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROFESSION_PEOPLE + " TEXT, "
                + COLUMN_CONCRETE_PROFY_PEOPLE + " TEXT, "
                + COLUMN_NAME_PEOPLE + " TEXT, "
                + COLUMN_PHOTO_PEOPLE + " TEXT, "
                + COLUMN_DESCRIPTION_PEOPLE + " TEXT);");

        db.execSQL("INSERT INTO " + TABLE_PEOPLE + " (" + COLUMN_PROFESSION_PEOPLE
                + ", " + COLUMN_CONCRETE_PROFY_PEOPLE + ", " + COLUMN_NAME_PEOPLE
                + ", " + COLUMN_PHOTO_PEOPLE + ", " + COLUMN_DESCRIPTION_PEOPLE + ") VALUES " +
                "('" + PROFESSION_WRITER + "', '" + CONCRETE_PROFESSION_WRITER_POET + "', 'Пушкин Александр Сергеевич', 'res/drawable/pushkin.jpg', 'Алекса́ндр Серге́евич Пу́шкин (26 мая [6 июня] 1799, Москва — 29 января [10 февраля] 1837, Санкт-Петербург) — русский поэт, драматург и прозаик, заложивший основы русского реалистического направления, критик и теоретик литературы, историк, публицист; один из самых авторитетных литературных деятелей первой трети XIX века. Ещё при жизни Пушкина сложилась его репутация величайшего национального русского поэта. Пушкин рассматривается как основоположник современного русского литературного языка.')," +
                "('" + PROFESSION_WRITER + "', '" + CONCRETE_PROFESSION_WRITER_PROSE + "', 'Лев Николаевич Толстой', 'res/drawable/lev.jpg', 'Граф Лев Никола́евич Толстой (28 августа [9 сентября] 1828, Ясная Поляна, Тульская губерния, Российская империя — 7 [20] ноября 1910, станция Астапово, Рязанская губерния, Российская империя) — один из наиболее известных русских писателей и мыслителей, один из величайших писателей-романистов мира. Участник обороны Севастополя. Просветитель, публицист, религиозный мыслитель, его авторитетное мнение послужило причиной возникновения нового религиозно-нравственного течения — толстовства. Член-корреспондент Императорской Академии наук (1873), почётный академик по разряду изящной словесности (1900). Был номинирован на Нобелевскую премию по литературе (1902, 1903, 1904, 1905).')," +
                "('" + PROFESSION_WRITER + "', '" + CONCRETE_PROFESSION_WRITER_PROSE + "', 'Иван Сергеевич Тургенев', 'res/drawable/turgenev.jpg', 'Ива́н Серге́евич Турге́нев (28 октября [9 ноября] 1818, Орёл, Российская империя — 22 августа [3 сентября] 1883, Буживаль, Франция) — русский писатель-реалист, поэт, публицист, драматург, переводчик. Один из классиков русской литературы, внёсших наиболее значительный вклад в её развитие во второй половине XIX века. Член-корреспондент императорской Академии наук по разряду русского языка и словесности (1860), почётный доктор Оксфордского университета (1879), почётный член Московского университета (1880).')," +
                "('" + PROFESSION_WRITER + "', '" + CONCRETE_PROFESSION_WRITER_POET + "', 'Владимир Владимирович Маяковский', 'res/drawable/majakovski.jpg', 'Владимир Владимирович Маяковский (7 [19] июля 1893, Багдати, Кутаисская губерния — 14 апреля 1930, Москва) — русский советский поэт. Один из крупнейших поэтов XX века.Помимо поэзии ярко проявил себя как драматург, киносценарист, кинорежиссёр, киноактёр, художник, редактор журналов «ЛЕФ» («Левый фронт»), «Новый ЛЕФ».')," +
                "('" + PROFESSION_ARTIST + "', '" + CONCRETE_PROFESSION_ARTIST_ABSTRACTIONISM + "', 'Василий Васильевич Кандинский', 'res/drawable/kandinski.jpg', 'Васи́лий Васи́льевич Канди́нский (4 (16) декабря 1866, Москва — 13 декабря 1944, Нёйи-сюр-Сен, Франция) — русский художник и теоретик изобразительного искусства, один из основоположников абстракционизма. Был одним из основателей группы «Синий всадник».')," +
                "('" + PROFESSION_ARTIST + "', '" + CONCRETE_PROFESSION_ARTIST_AVANT_GARDISM + "', 'Пабло Пикассо', 'res/drawable/picasso.jpg', 'Испанский и французский художник, скульптор, график, театральный художник, керамист и дизайнер. Основоположник кубизма (совместно с Жоржем Браком и Хуаном Грисом), в котором трёхмерное тело в оригинальной манере изображалось как ряд совмещённых воедино плоскостей. Пикассо много работал как график, скульптор, керамист и т. д. Вызвал к жизни массу подражателей и оказал исключительное влияние на развитие изобразительного искусства в XX веке. Согласно оценке Музея современного искусства (Нью-Йорк), Пикассо за свою жизнь создал около 20 тысяч работ.')," +
                "('" + PROFESSION_SCIENTIST + "', '" + CONCRETE_PROFESSION_SCIENTIST_MATHEMATICIAN + "', 'Карл Фридрих Гаусс', 'res/drawable/gauss.jpg', 'Иоганн Карл Фридрих Гаусс (нем. Johann Carl Friedrich Gauß; 30 апреля 1777, Брауншвейг — 23 февраля 1855, Гёттинген) — немецкий математик, механик, физик, астроном и геодезист. Считается одним из величайших математиков всех времён, «королём математиков». Лауреат медали Копли (1838), иностранный член Шведской (1821) и Российской (1824) Академий наук, английского Королевского общества.')," +
                "('" + PROFESSION_SCIENTIST + "', '" + CONCRETE_PROFESSION_SCIENTIST_MATHEMATICIAN + "', 'Пьер де Ферма́', 'res/drawable/ferma.jpg', 'Пьер де Ферма́ (фр. Pierre de Fermat, 17 августа 1601 — 12 января 1665) — французский математик-самоучка, один из создателей аналитической геометрии, математического анализа, теории вероятностей и теории чисел. По профессии юрист, с 1631 года — советник парламента в Тулузе. Блестящий полиглот. Наиболее известен формулировкой Великой теоремы Ферма, «самой знаменитой математической загадки всех времён».')," +
                "('" + PROFESSION_SCIENTIST + "', '" + CONCRETE_PROFESSION_SCIENTIST_PHYSICIAN + "', 'Альберт Эйнштейн', 'res/drawable/albert.jpg', 'Альбе́рт Эйнште́йн (нем. Albert Einstein; 14 марта 1879, Ульм, Вюртемберг, Германия — 18 апреля 1955, Принстон, Нью-Джерси, США) — физик-теоретик, один из основателей современной теоретической физики, лауреат Нобелевской премии по физике 1921 года, общественный деятель-гуманист.')," +
                "('" + PROFESSION_SCIENTIST + "', '" + CONCRETE_PROFESSION_SCIENTIST_PHYSICIAN + "', 'Исаак Ньютон', 'res/drawable/isaak.jpg', 'Сэр Исаак Ньютон (или Ньютон) (англ. Isaac Newton /ˈnjuːtən/, 25 декабря 1642 года — 20 марта 1727 года по юлианскому календарю, действовавшему в Англии до 1752 года; или 4 января 1643 года — 31 марта 1727 года по григорианскому календарю) — английский физик, математик, механик и астроном, один из создателей классической физики.')," +
                "('" + PROFESSION_SPORTSMAN + "', '" + CONCRETE_PROFESSION_SPORTSMAN_FOOTBALL + "', 'Лионель Мессси', 'res/drawable/messi1.jpg', 'Лионе́ль Андре́с Ме́сси (исп. Lionel Andrés Messi; род. 24 июня 1987, Росарио, Аргентина) — аргентинский футболист, нападающий испанского клуба «Барселона», с 2011 года — капитан национальной сборной Аргентины. Лучший бомбардир в истории «Барселоны» и сборной Аргентины. Считается одним из лучших футболистов современности и одним из лучшиx игроков всеx времён.')," +
                "('" + PROFESSION_SPORTSMAN + "', '" + CONCRETE_PROFESSION_SPORTSMAN_FOOTBALL + "', 'Криштиану Роналду', 'res/drawable/ronaldo.jpg', 'Криштиа́ну Рона́лду душ Са́нтуш Аве́йру (порт. Cristiano Ronaldo dos Santos Aveiro; род. 5 февраля 1985, Фуншал) — португальский футболист, выступающий за испанский клуб «Реал Мадрид» и сборную Португалии, в составе которой стал чемпионом Европы 2016 года. Лучший бомбардир в истории клуба «Реал Мадрид» и сборной Португалии. Капитан сборной Португалии.')," +
                "('" + PROFESSION_SPORTSMAN + "', '" + CONCRETE_PROFESSION_SPORTSMAN_HOCKEY + "', 'Александр Михайлович Овечкин', 'res/drawable/ovechkin.jpg', 'Алекса́ндр Миха́йлович Ове́чкин (17 сентября 1985, Москва, СССР) — российский профессиональный хоккеист, левый крайний нападающий клуба НХЛ «Вашингтон Кэпиталз». Обладатель Кубка Стэнли 2018 года. Трёхкратный чемпион мира (2008, 2012, 2014).')," +
                "('" + PROFESSION_POLITICIAN + "', '" + CONCRETE_PROFESSION_POLITICIAN_REVOLUTIONER + "', 'Владимир Ильич Ленин', 'res/drawable/lenin.jpg', 'Влади́мир Ильи́ч Улья́нов (основной псевдоним Ле́нин; 10 (22) апреля 1870, Симбирск — 21 января 1924, усадьба Горки, Московская губерния) — российский революционер, крупный теоретик марксизма, советский политический и государственный деятель, создатель Российской социал-демократической рабочей партии (большевиков), главный организатор и руководитель Октябрьской революции 1917 года в России, первый председатель Совета Народных Комиссаров (правительства) РСФСР, создатель первого в мировой истории социалистического государства.')," +
                "('" + PROFESSION_POLITICIAN + "', '" + CONCRETE_PROFESSION_POLITICIAN_PRESIDENT + "', 'Барак Обама', 'res/drawable/obama.jpg', 'Бара́к Хуссе́йн Оба́ма II (англ. Barack Hussein Obama II, произносится [bəˈrɑːk huːˈseɪn oʊˈbɑːmə] амер. Listeni/bəˈrɑːk huːˈseɪn ɵˈbɑːmə/; род. 4 августа 1961, Гонолулу, Гавайи, США) — 44-й президент Соединённых Штатов Америки с 20 января 2009 года по 20 января 2017 года. Лауреат Нобелевской премии мира 2009 года. До избрания президентом являлся федеральным сенатором от штата Иллинойс. Был впервые избран в ноябре 2008 года, переизбран на второй президентский срок в 2012 году.')," +
                "('" + PROFESSION_POLITICIAN + "', '" + CONCRETE_PROFESSION_POLITICIAN_KING + "', 'Салман ибн Абдул-Азиз Аль Сауд', 'res/drawable/alsaud.jpg', 'Абдалла́ ибн Абду́л-Ази́з ибн Абдуррахма́н А́ль Сау́д (араб. عبد الله بن عبد العزيز بن عبد الرحمن آل سعود\u200E\u200E / 1 августа 1924, Эр-Рияд — 23 января 2015, Эр-Рияд) — король Саудовской Аравии и Хранитель двух святынь в 2005—2015 годах.')," +
                "('" + PROFESSION_SINGER + "', '" + CONCRETE_PROFESSION_SINGER_GROUP + "', 'Twenty One Pilots', 'res/drawable/top.jpg', 'Twenty One Pilots (также часто стилизуют под twenty one pilots или TWENTY ØNE PILØTS) — американский дуэт из Колумбуса, штат Огайо. Группа образовалась в 2009 году и на данный момент состоит из Тайлера Джозефа и Джоша Дана. Коллектив самостоятельно выпустил два альбома: Twenty One Pilots в 2009 и Regional at Best в 2011. В 2012 году музыканты подписывают контракт с Fueled by Ramen, в 2013 выпускают студийный альбом Vessel, а в 2015 студийный альбом — Blurryface.')," +
                "('" + PROFESSION_SINGER + "', '" + CONCRETE_PROFESSION_SINGER_GROUP + "', 'Hurts', 'res/drawable/hurts.jpg', 'Hurts — британский музыкальный коллектив из Манчестера, образовавшийся в 2009 году, состоящий из Тео Хатчкрафта и Адама Андерсона. Их первые два альбома, Happiness и Exile, попали в десятку лучших альбомов в Великобритании, Германии, Австрии, Швейцарии, Польше и Финляндии.')," +
                "('" + PROFESSION_SINGER + "', '" + CONCRETE_PROFESSION_SINGER_SOLO + "', 'Елена Ваенга', 'res/drawable/vaenga.jpg', 'Еле́на Ва́енга (настоящее имя — Еле́на Влади́мировна Хрулёва; род. 27 января 1977, Североморск, Мурманская область, РСФСР, СССР) — российская эстрадная певица, автор песен, актриса. Лауреат премий «Шансон года».')," +
                "('" + PROFESSION_SINGER + "','"+CONCRETE_PROFESSION_SINGER_SOLO+"', 'Сергей Михайлович Пенкин','res/drawable/penkin.jpg','Cерге́й Миха́йлович Пе́нкин (род. 10 февраля 1961, Пенза) — советский и российский певец, композитор и актёр. Известен диапазоном своего голоса, охватывающим четыре октавы. Репертуар Сергея включает русские народные песни, романсы, популярные западные шлягеры. Известными в исполнении певца стали песни «Feelings[en]», «Дождь осенний», «В другую весну», «Призрак оперы», «Caruso», «Триумф Дон Жуана», «Ария мистера Икс», «Живёт моя отрада», «Очи чёрные», «Я вас любил», «Вечерний звон» — всего более 140 песен.');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
