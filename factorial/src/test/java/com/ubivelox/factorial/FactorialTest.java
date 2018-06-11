package com.ubivelox.factorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ubivelox.exception.UbiveloxException;
import com.ubivelox.factorial.Factorial.Factor;

public class FactorialTest
{
    @Test
    public void testGetZeroCount0() throws UbiveloxException
    {
        // System.out.println(Math.sqrt(27));

        // List<Factor> list = new ArrayList<>();
        // list.add(new Factor(2l, 2l));
        // Factorial.getList1(Long.MAX_VALUE);

        // assertEquals(7, Factorial.getZeroCount(Long.MAX_VALUE, Long.MAX_VALUE));
        // assertEquals(7, Factorial.getZeroCount(30, Integer.MAX_VALUE));
        // assertEquals(7, Factorial.getZeroCount(30, 9223372036854775800l));
        assertEquals(24, Factorial.getZeroCount(400, 17));
        System.out.println(Factorial.getZeroCount(Long.MAX_VALUE, Long.MAX_VALUE));
        System.out.println(Factorial.getZeroCount(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(222222222221l, Factorial.getZeroCount(77777777777777l, 71 * 71 * 71 * 71 * 71));
        assertEquals(24976807249l, Factorial.getZeroCount(77777777777777l, 1039 * 1039 * 1039));
        assertEquals(37465210874l, Factorial.getZeroCount(77777777777777l, 1039 * 1039));
        assertEquals(74930421748l, Factorial.getZeroCount(77777777777777l, (1039)));
        assertEquals(13634220, Factorial.getZeroCount(777777777777l, 13 * 22 * 57047));
        assertEquals(4326358, Factorial.getZeroCount(246801467923l, 13 * 22 * 57047));
        assertEquals(134043, Factorial.getZeroCount(2468014679l, 13 * 17 * 18413));
        assertEquals(551145, Factorial.getZeroCount(123456789, 2 * 3 * 5 * 13 * 13 * 113 * 113));
        assertEquals(117576, Factorial.getZeroCount(9876543, 2 * 13 * 5 * 5 * 7 * 29 * 29 * 29));
        assertEquals(1443, Factorial.getZeroCount(52000, 13 * 13 * 13));
        assertEquals(80, Factorial.getZeroCount(6800, 2 * 13 * 5 * 5 * 7 * 29 * 29 * 29));
        assertEquals(7, Factorial.getZeroCount(30, 15));
        assertEquals(6, Factorial.getZeroCount(30, 16));
        assertEquals(13, Factorial.getZeroCount(30, 12));
        assertEquals(3, Factorial.getZeroCount(25, 14));
        assertEquals(10, Factorial.getZeroCount(25, 12));
        assertEquals(10, Factorial.getZeroCount(25, 12));
        assertEquals(5, Factorial.getZeroCount(25, 18));
        assertEquals(10, Factorial.getZeroCount(25, 12));
        assertEquals(5, Factorial.getZeroCount(25, 18));
        assertEquals(1, Factorial.getZeroCount(20, 19));
        assertEquals(1, Factorial.getZeroCount(20, 17));
        assertEquals(4, Factorial.getZeroCount(20, 16));
        assertEquals(4, Factorial.getZeroCount(20, 15));
        assertEquals(2, Factorial.getZeroCount(20, 14));
        assertEquals(3, Factorial.getZeroCount(25, 14));
        assertEquals(1, Factorial.getZeroCount(20, 13));
        assertEquals(18, Factorial.getZeroCount(40, 12));
        assertEquals(4, Factorial.getZeroCount(20, 9));
        assertEquals(6, Factorial.getZeroCount(20, 8));

    }





    @Test
    public void testGetZeroCount1() throws UbiveloxException
    {

        List<Factor> list = new ArrayList<>();
        list.add(new Factor(2l, 2l));
        assertEquals(list, Factorial.getList(4));
        list.clear();
        list.add(new Factor(2l, 2l));
        list.add(new Factor(3l, 1l));
        assertEquals(list, Factorial.getList(12l));
        list.clear();
        list.add(new Factor(2l, 4l));
        assertEquals(list, Factorial.getList(16l));
        list.clear();
        list.add(new Factor(3l, 1l));
        list.add(new Factor(5l, 1l));
        assertEquals(list, Factorial.getList(15l));
        list.clear();
        list.add(new Factor(2l, 1l));
        list.add(new Factor(11l, 1l));
        assertEquals(list, Factorial.getList(22l));
        list.clear();
        list.add(new Factor(2l, 2l));
        list.add(new Factor(7l, 1l));
        assertEquals(list, Factorial.getList(28l));

        list.clear();

        list.add(new Factor(2l, 2l));
        list.add(new Factor(3l, 1l));
        list.add(new Factor(5l, 2l));
        list.add(new Factor(7l, 1l));
        list.add(new Factor(11l, 2l));
        assertEquals(list, Factorial.getList(2 * 2 * 3 * 5 * 5 * 7 * 11 * 11));

        // 10진수일 때
        assertEquals(97, Factorial.getCount(100, new Factor(2l, 1l)));
        assertEquals(24, Factorial.getCount(100, new Factor(5l, 1l)));

        // 12진수일 때
        assertEquals(11, Factorial.getCount(25, new Factor(2l, 2l)));
        assertEquals(10, Factorial.getCount(25, new Factor(3l, 1l)));

        // 12진수일 때
        assertEquals(11, Factorial.getCount(25, new Factor(2l, 2l)));
        assertEquals(10, Factorial.getCount(25, new Factor(3l, 1l)));

        // 16진수일 때
        assertEquals(5, Factorial.getCount(25, new Factor(2l, 4l)));
        assertEquals(4, Factorial.getCount(20, new Factor(2l, 4l)));
        assertEquals(6, Factorial.getCount(30, new Factor(2l, 4l)));

        // 18진수일 때
        assertEquals(22, Factorial.getCount(25, new Factor(2l, 1l)));
        assertEquals(5, Factorial.getCount(25, new Factor(3l, 2l)));

        // 19진수일 때
        assertEquals(1, Factorial.getCount(20, new Factor(19l, 1l)));

        // 17진수일 때
        assertEquals(1, Factorial.getCount(20, new Factor(17l, 1l)));

        // 14진수일 때
        assertEquals(18, Factorial.getCount(20, new Factor(2l, 1l)));
        assertEquals(2, Factorial.getCount(20, new Factor(7l, 1l)));

        // 14진수일 때
        assertEquals(22, Factorial.getCount(25, new Factor(2l, 1l)));
        assertEquals(3, Factorial.getCount(25, new Factor(7l, 1l)));

        // 12진수일 때
        assertEquals(19, Factorial.getCount(40, new Factor(2l, 2l)));
        assertEquals(18, Factorial.getCount(40, new Factor(3l, 1l)));

        // 9진수일 때
        assertEquals(4, Factorial.getCount(20, new Factor(3l, 2l)));

        // 8진수일 때
        assertEquals(6, Factorial.getCount(20, new Factor(2l, 3l)));

        assertEquals(57, Factorial.getZeroCount(690, 2 * 13 * 5 * 5 * 7));
        assertEquals(52, Factorial.getZeroCount(850, 17));
        assertEquals(6, Factorial.getZeroCount(20, 2 * 2 * 2));

        assertEquals(7, Factorial.getZeroCount(30, 15));

        assertEquals(7, Factorial.getZeroCount(30, 15));
        assertEquals(6, Factorial.getZeroCount(30, 16));
        assertEquals(13, Factorial.getZeroCount(30, 12));
        assertEquals(3, Factorial.getZeroCount(25, 14));
        assertEquals(10, Factorial.getZeroCount(25, 12));
        assertEquals(10, Factorial.getZeroCount(25, 12));
        assertEquals(5, Factorial.getZeroCount(25, 18));
        assertEquals(10, Factorial.getZeroCount(25, 12));
        assertEquals(5, Factorial.getZeroCount(25, 18));
        assertEquals(1, Factorial.getZeroCount(20, 19));
        assertEquals(1, Factorial.getZeroCount(20, 17));
        assertEquals(4, Factorial.getZeroCount(20, 16));
        assertEquals(4, Factorial.getZeroCount(20, 15));
        assertEquals(2, Factorial.getZeroCount(20, 14));
        assertEquals(3, Factorial.getZeroCount(25, 14));
        assertEquals(1, Factorial.getZeroCount(20, 13));
        assertEquals(18, Factorial.getZeroCount(40, 12));
        assertEquals(4, Factorial.getZeroCount(20, 9));
        assertEquals(6, Factorial.getZeroCount(20, 8));

        assertEquals(499999988, Factorial.getZeroCount(1999999999, 10));
        assertEquals(249999989, Factorial.getZeroCount(999999999, 10));
        //
        assertEquals(2499, Factorial.getZeroCount(10000, 10));
        assertEquals(999, Factorial.getZeroCount(4000, 10));
        assertEquals(499, Factorial.getZeroCount(2000, 10));
        assertEquals(249, Factorial.getZeroCount(1000, 10));
        assertEquals(124, Factorial.getZeroCount(500, 10));
        assertEquals(74, Factorial.getZeroCount(300, 10));

        assertEquals(46, Factorial.getZeroCount(190, 10));
        assertEquals(41, Factorial.getZeroCount(170, 10));
        assertEquals(37, Factorial.getZeroCount(150, 10));
        assertEquals(32, Factorial.getZeroCount(130, 10));
        assertEquals(26, Factorial.getZeroCount(110, 10));

        assertEquals(24, Factorial.getZeroCount(100, 10));
        assertEquals(22, Factorial.getZeroCount(99, 10));
        assertEquals(22, Factorial.getZeroCount(98, 10));
        assertEquals(22, Factorial.getZeroCount(97, 10));
        assertEquals(22, Factorial.getZeroCount(96, 10));

        assertEquals(22, Factorial.getZeroCount(95, 10));
        assertEquals(21, Factorial.getZeroCount(94, 10));
        assertEquals(21, Factorial.getZeroCount(93, 10));
        assertEquals(21, Factorial.getZeroCount(92, 10));
        assertEquals(21, Factorial.getZeroCount(91, 10));

        assertEquals(21, Factorial.getZeroCount(90, 10));
        assertEquals(20, Factorial.getZeroCount(89, 10));
        assertEquals(20, Factorial.getZeroCount(88, 10));
        assertEquals(20, Factorial.getZeroCount(87, 10));
        assertEquals(20, Factorial.getZeroCount(86, 10));

        assertEquals(20, Factorial.getZeroCount(85, 10));
        assertEquals(19, Factorial.getZeroCount(84, 10));
        assertEquals(19, Factorial.getZeroCount(83, 10));
        assertEquals(19, Factorial.getZeroCount(82, 10));
        assertEquals(19, Factorial.getZeroCount(81, 10));

        assertEquals(19, Factorial.getZeroCount(80, 10));
        assertEquals(18, Factorial.getZeroCount(79, 10));
        assertEquals(18, Factorial.getZeroCount(78, 10));
        assertEquals(18, Factorial.getZeroCount(77, 10));
        assertEquals(18, Factorial.getZeroCount(76, 10));

        assertEquals(18, Factorial.getZeroCount(75, 10));
        assertEquals(16, Factorial.getZeroCount(74, 10));
        assertEquals(16, Factorial.getZeroCount(73, 10));
        assertEquals(16, Factorial.getZeroCount(72, 10));
        assertEquals(16, Factorial.getZeroCount(71, 10));

        assertEquals(16, Factorial.getZeroCount(70, 10));
        assertEquals(15, Factorial.getZeroCount(69, 10));
        assertEquals(15, Factorial.getZeroCount(68, 10));
        assertEquals(15, Factorial.getZeroCount(67, 10));
        assertEquals(15, Factorial.getZeroCount(66, 10));

        assertEquals(15, Factorial.getZeroCount(65, 10));
        assertEquals(14, Factorial.getZeroCount(64, 10));
        assertEquals(14, Factorial.getZeroCount(63, 10));
        assertEquals(14, Factorial.getZeroCount(62, 10));
        assertEquals(14, Factorial.getZeroCount(61, 10));

        assertEquals(14, Factorial.getZeroCount(60, 10));
        assertEquals(13, Factorial.getZeroCount(59, 10));
        assertEquals(13, Factorial.getZeroCount(58, 10));
        assertEquals(13, Factorial.getZeroCount(57, 10));
        assertEquals(13, Factorial.getZeroCount(56, 10));

        assertEquals(13, Factorial.getZeroCount(55, 10));
        assertEquals(12, Factorial.getZeroCount(54, 10));
        assertEquals(12, Factorial.getZeroCount(53, 10));
        assertEquals(12, Factorial.getZeroCount(52, 10));
        assertEquals(12, Factorial.getZeroCount(51, 10));

        assertEquals(12, Factorial.getZeroCount(50, 10));
        assertEquals(10, Factorial.getZeroCount(49, 10));
        assertEquals(10, Factorial.getZeroCount(48, 10));
        assertEquals(10, Factorial.getZeroCount(47, 10));
        assertEquals(10, Factorial.getZeroCount(46, 10));

        assertEquals(10, Factorial.getZeroCount(45, 10));
        assertEquals(9, Factorial.getZeroCount(44, 10));
        assertEquals(9, Factorial.getZeroCount(43, 10));
        assertEquals(9, Factorial.getZeroCount(42, 10));
        assertEquals(9, Factorial.getZeroCount(41, 10));

        assertEquals(9, Factorial.getZeroCount(40, 10));
        assertEquals(8, Factorial.getZeroCount(39, 10));
        assertEquals(8, Factorial.getZeroCount(38, 10));
        assertEquals(8, Factorial.getZeroCount(37, 10));
        assertEquals(8, Factorial.getZeroCount(36, 10));

        assertEquals(8, Factorial.getZeroCount(35, 10));
        assertEquals(7, Factorial.getZeroCount(34, 10));
        assertEquals(7, Factorial.getZeroCount(33, 10));
        assertEquals(7, Factorial.getZeroCount(32, 10));
        assertEquals(7, Factorial.getZeroCount(31, 10));

        assertEquals(7, Factorial.getZeroCount(30, 10));
        assertEquals(6, Factorial.getZeroCount(29, 10));
        assertEquals(6, Factorial.getZeroCount(28, 10));
        assertEquals(6, Factorial.getZeroCount(27, 10));
        assertEquals(6, Factorial.getZeroCount(26, 10));

        assertEquals(6, Factorial.getZeroCount(25, 10));
        assertEquals(4, Factorial.getZeroCount(24, 10));
        assertEquals(4, Factorial.getZeroCount(23, 10));
        assertEquals(4, Factorial.getZeroCount(22, 10));
        assertEquals(4, Factorial.getZeroCount(21, 10));

        assertEquals(4, Factorial.getZeroCount(20, 10));
        assertEquals(3, Factorial.getZeroCount(19, 10));
        assertEquals(3, Factorial.getZeroCount(18, 10));
        assertEquals(3, Factorial.getZeroCount(17, 10));
        assertEquals(3, Factorial.getZeroCount(16, 10));

        assertEquals(3, Factorial.getZeroCount(15, 10));
        assertEquals(2, Factorial.getZeroCount(14, 10));
        assertEquals(2, Factorial.getZeroCount(13, 10));
        assertEquals(2, Factorial.getZeroCount(12, 10));
        assertEquals(2, Factorial.getZeroCount(11, 10));

        assertEquals(2, Factorial.getZeroCount(10, 10));
        assertEquals(1, Factorial.getZeroCount(9, 10));
        assertEquals(1, Factorial.getZeroCount(8, 10));
        assertEquals(1, Factorial.getZeroCount(7, 10));
        assertEquals(1, Factorial.getZeroCount(6, 10));

        assertEquals(1, Factorial.getZeroCount(5, 10));
        assertEquals(0, Factorial.getZeroCount(4, 10));
        assertEquals(0, Factorial.getZeroCount(3, 10));
        assertEquals(0, Factorial.getZeroCount(2, 10));
        assertEquals(0, Factorial.getZeroCount(1, 10));
        assertEquals(0, Factorial.getZeroCount(0, 10));
    }





    @Test
    public void testError()
    {

        getCountException(20, null, "에러 : Factor가 null 입니다.");
        getCountException(20, new Factor(0, 2l), "에러 : number가 0 입니다.");
        getCountException(20, new Factor(3l, 0), "에러 : exponentiation가 0 입니다.");

        getException(123214, 0, "에러 : 값 1 또는 0 또는 음수");
        getException(30, 0, "에러 : 값 1 또는 0 또는 음수");
        getException(30, 0, "에러 : 값 1 또는 0 또는 음수");
        getException(30, -1, "에러 : 값 1 또는 0 또는 음수");
        getException(-199, 10, "에러 : 음수");
        getException(-12, 10, "에러 : 음수");
        getException(-1, 10, "에러 : 음수");
    }





    private void getCountException(final int num, final Factor factor, final String errorMessage)
    {
        try
        {
            Factorial.getCount(num, factor);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }





    private void getException(final int num, final int jinsu, final String errorMessage)
    {
        try
        {
            Factorial.getZeroCount(num, jinsu);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }
}

// 0! = 1
// 1! = 1
// 2! = 2
// 3! = 6
// 4! = 24
// 5! = 120
// 6! = 720
// 7! = 5040
// 8! = 40320
// 9! = 362880
// 10! = 3628800
// 11! = 39916800
// 12! = 479001600
// 13! = 6227020800
// 14! = 87178291200
// 15! = 1307674368000
// 16! = 20922789888000
// 17! = 355687428096000
// 18! = 6402373705728000
// 19! = 121645100408832000
// 20! = 2432902008176640000
// 21! = 51090942171709440000
// 22! = 1124000727777607680000
// 23! = 25852016738884976640000
// 24! = 620448401733239439360000
// 25! = 15511210043330985984000000
// 26! = 403291461126605635584000000
// 27! = 10888869450418352160768000000
// 28! = 304888344611713860501504000000
// 29! = 8841761993739701954543616000000
// 30! = 265252859812191058636308480000000
// 31! = 8222838654177922817725562880000000
// 32! = 263130836933693530167218012160000000
// 33! = 8683317618811886495518194401280000000
// 34! = 295232799039604140847618609643520000000
// 35! = 10333147966386144929666651337523200000000
// 36! = 371993326789901217467999448150835200000000
// 37! = 13763753091226345046315979581580902400000000
// 38! = 523022617466601111760007224100074291200000000
// 39! = 20397882081197443358640281739902897356800000000
// 40! = 815915283247897734345611269596115894272000000000
// 41! = 33452526613163807108170062053440751665152000000000
// 42! = 1405006117752879898543142606244511569936384000000000
// 43! = 60415263063373835637355132068513997507264512000000000
// 44! = 2658271574788448768043625811014615890319638528000000000
// 45! = 119622220865480194561963161495657715064383733760000000000
// 46! = 5502622159812088949850305428800254892961651752960000000000
// 47! = 258623241511168180642964355153611979969197632389120000000000
// 48! = 12413915592536072670862289047373375038521486354677760000000000
// 49! = 608281864034267560872252163321295376887552831379210240000000000
// 50! = 30414093201713378043612608166064768844377641568960512000000000000
// 51! = 1551118753287382280224243016469303211063259720016986112000000000000
// 52! = 80658175170943878571660636856403766975289505440883277824000000000000
// 53! = 4274883284060025564298013753389399649690343788366813724672000000000000
// 54! = 230843697339241380472092742683027581083278564571807941132288000000000000
// 55! = 12696403353658275925965100847566516959580321051449436762275840000000000000
// 56! = 710998587804863451854045647463724949736497978881168458687447040000000000000
// 57! = 40526919504877216755680601905432322134980384796226602145184481280000000000000
// 58! = 2350561331282878571829474910515074683828862318181142924420699914240000000000000
// 59! = 138683118545689835737939019720389406345902876772687432540821294940160000000000000
// 60! = 8320987112741390144276341183223364380754172606361245952449277696409600000000000000
// 61! = 507580213877224798800856812176625227226004528988036003099405939480985600000000000000
// 62! = 31469973260387937525653122354950764088012280797258232192163168247821107200000000000000
// 63! = 1982608315404440064116146708361898137544773690227268628106279599612729753600000000000000
// 64! = 126886932185884164103433389335161480802865516174545192198801894375214704230400000000000000
// 65! = 8247650592082470666723170306785496252186258551345437492922123134388955774976000000000000000
// 66! = 544344939077443064003729240247842752644293064388798874532860126869671081148416000000000000000
// 67! = 36471110918188685288249859096605464427167635314049524593701628500267962436943872000000000000000
// 68! = 2480035542436830599600990418569171581047399201355367672371710738018221445712183296000000000000000
// 69! = 171122452428141311372468338881272839092270544893520369393648040923257279754140647424000000000000000
// 70! = 11978571669969891796072783721689098736458938142546425857555362864628009582789845319680000000000000000
// 71! = 850478588567862317521167644239926010288584608120796235886430763388588680378079017697280000000000000000
// 72! = 61234458376886086861524070385274672740778091784697328983823014963978384987221689274204160000000000000000
// 73! = 4470115461512684340891257138125051110076800700282905015819080092370422104067183317016903680000000000000000
// 74! = 330788544151938641225953028221253782145683251820934971170611926835411235700971565459250872320000000000000000
// 75! = 24809140811395398091946477116594033660926243886570122837795894512655842677572867409443815424000000000000000000
// 76! = 1885494701666050254987932260861146558230394535379329335672487982961844043495537923117729972224000000000000000000
// 77! = 145183092028285869634070784086308284983740379224208358846781574688061991349156420080065207861248000000000000000000
// 78! = 11324281178206297831457521158732046228731749579488251990048962825668835325234200766245086213177344000000000000000000
// 79! = 894618213078297528685144171539831652069808216779571907213868063227837990693501860533361810841010176000000000000000000
// 80! = 71569457046263802294811533723186532165584657342365752577109445058227039255480148842668944867280814080000000000000000000
// 81! = 5797126020747367985879734231578109105412357244731625958745865049716390179693892056256184534249745940480000000000000000000
// 82! = 475364333701284174842138206989404946643813294067993328617160934076743994734899148613007131808479167119360000000000000000000
// 83! = 39455239697206586511897471180120610571436503407643446275224357528369751562996629334879591940103770870906880000000000000000000
// 84! = 3314240134565353266999387579130131288000666286242049487118846032383059131291716864129885722968716753156177920000000000000000000
// 85! = 281710411438055027694947944226061159480056634330574206405101912752560026159795933451040286452340924018275123200000000000000000000
// 86! = 24227095383672732381765523203441259715284870552429381750838764496720162249742450276789464634901319465571660595200000000000000000000
// 87! = 2107757298379527717213600518699389595229783738061356212322972511214654115727593174080683423236414793504734471782400000000000000000000
// 88! = 185482642257398439114796845645546284380220968949399346684421580986889562184028199319100141244804501828416633516851200000000000000000000
// 89! = 16507955160908461081216919262453619309839666236496541854913520707833171034378509739399912570787600662729080382999756800000000000000000000
// 90! = 1485715964481761497309522733620825737885569961284688766942216863704985393094065876545992131370884059645617234469978112000000000000000000000
// 91! = 135200152767840296255166568759495142147586866476906677791741734597153670771559994765685283954750449427751168336768008192000000000000000000000
// 92! = 12438414054641307255475324325873553077577991715875414356840239582938137710983519518443046123837041347353107486982656753664000000000000000000000
// 93! = 1156772507081641574759205162306240436214753229576413535186142281213246807121467315215203289516844845303838996289387078090752000000000000000000000
// 94! = 108736615665674308027365285256786601004186803580182872307497374434045199869417927630229109214583415458560865651202385340530688000000000000000000000
// 95! = 10329978488239059262599702099394727095397746340117372869212250571234293987594703124871765375385424468563282236864226607350415360000000000000000000000
// 96! = 991677934870949689209571401541893801158183648651267795444376054838492222809091499987689476037000748982075094738965754305639874560000000000000000000000
// 97! = 96192759682482119853328425949563698712343813919172976158104477319333745612481875498805879175589072651261284189679678167647067832320000000000000000000000
// 98! = 9426890448883247745626185743057242473809693764078951663494238777294707070023223798882976159207729119823605850588608460429412647567360000000000000000000000
// 99! = 933262154439441526816992388562667004907159682643816214685929638952175999932299156089414639761565182862536979208272237582511852109168640000000000000000000000
// 100! = 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
