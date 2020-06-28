package com.example.final_project;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SearchConstellation extends AppCompatActivity {
    TextView txvANS,txvDate,title1,content1,title2,content2,title3,content3,title4,content4,title5,content5;
    int m,d;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_constellation);

        title1 = findViewById(R.id.title1);
        content1 = findViewById(R.id.content1);
        title2 = findViewById(R.id.title2);
        content2 = findViewById(R.id.content2);
        title3 = findViewById(R.id.title3);
        content3 = findViewById(R.id.content3);
        title4 = findViewById(R.id.title4);
        content4 = findViewById(R.id.content4);
        title5 = findViewById(R.id.title5);
        content5 = findViewById(R.id.content5);
        txvANS = findViewById(R.id.txvANS);
        txvDate = findViewById(R.id.txvDate);
        imageView = findViewById(R.id.imageView);

        //取得上一個activity回傳的日期
        m = getIntent().getIntExtra("m",1);
        d = getIntent().getIntExtra("d",1);

        //顯示日期結果
        txvDate.setText(m+"月"+d+"日");

        //判斷月及日、以一個月有兩種星座作為邏輯基礎
        //以switch case判斷月
        //以if else判斷日
        switch(m){
            case 3:
                if (d>20){
                    aries();
                }else{
                    pisces();}
                break;
            case 4:
                if (d>20){
                    taurus();}
                else{
                    aries();
                    }
                break;
            case 5:
                if (d>21){
                    gemini();}
                else{
                    taurus();}
                break;
            case 6:
                if (d>21){
                    cancer();}
                else{
                    gemini();}
                break;
            case 7:
                if (d>22){
                    leo();}
                else{
                    cancer();}
                break;
            case 8:
                if (d>22){
                    virgo();}
                else{
                    leo();}
                break;
            case 9:
                if (d>22){
                    libra();}
                else{
                    virgo();}
                break;
            case 10:
                if (d>23){
                    scorpio();}
                else{
                    libra();}
                break;
            case 11:
                if (d>22){
                    sagittarius();}
                else{
                    scorpio();}
                break;
            case 12:
                if (d>21){
                    capricorn();}
                else{
                    sagittarius();}
                break;
            case 1:
                if (d>20){
                    aquarius();}
                else{
                    capricorn();}
                break;
            case 2:
                if (d>19){
                    pisces();}
                else{
                    aquarius();}
                break;
        }

    }

    public void aquarius(){
        imageView.setImageResource(R.drawable.aquarius);
        txvANS.setText("水瓶座");
        title1.setText("基本特質：");
        content1.setText("太陽位於水瓶座的人，極富革新精神，具有獨特的個性，有著超前的思想，是新思想的開拓者。聰穎脫俗，常有奇異的想法，不按牌理出牌。");
        title2.setText("具體特質：");
        content2.setText("水瓶座是黃道宮上的第十一個星座，主宰星為天王星，思想前衛，有開拓精神。太陽落在水瓶座的你，是一個反習俗、不願隨聲附和的人，說話和做事全憑自己的興趣，很有自己的主張，追求獨一無二的生活方式，物質享受與精神充實一樣重要。個性友善博愛、有創意和遠見，善於觀察分析。好奇心強，但會用理智分析，常常把強烈的願望和獨立精神融合在一起。喜歡自由自在的生活，隨心所欲地思考並做出決定。");
        title3.setText("行事風格：");
        content3.setText("你很有才華，喜歡創意，不喜歡一成不變的工作，重視邏輯思考的過程，在工作上常常有許多點子，也很喜歡做規劃，但對結果卻不太在意；在工作上也喜歡與大家分工合作，你動腦策劃他人出力。");
        title4.setText("個性盲點：");
        content4.setText("你需要注意的是，有時太過於執著，因而顯得有點固執，容易以自我為中心；喜歡創新、體現與眾不同，也容易誇大問題；太講求客觀，易給人冷漠無情的印象。");
        title5.setText("總結：");
        content5.setText("水瓶座的人很聰明，他們最大的特點是創新，追求獨一無二的生活，個人主義色彩很濃重的星座。他們對人友善又注重隱私。水瓶座絕對算得上是”友誼之星“，他喜歡結交每一類朋友，但是確很難與他們交心，那需要很長的時間。他們對自己的家人就顯得冷淡和疏遠很多了。");
    }
    public void pisces(){
        imageView.setImageResource(R.drawable.pisces);
        txvANS.setText("雙魚座");
        title1.setText("基本特質：");
        content1.setText("太陽位於雙魚座的人，內向害羞，有著濃厚的藝術氣息。柔情似水，浪漫多情，天真爛漫，會有許多夢幻般的想法，只是有時顯得不切實際。");
        title2.setText("具體特質：");
        content2.setText("雙魚座是黃道宮上最後一個星座，主宰星為海王星，注重心靈，非常感性。太陽落在雙魚座的你，性格上體貼、思想脫俗、多才多藝，身上有一種令人難以抗拒的奇異的魅力。你極具浪漫情懷，在知性與感性的衝擊下，往往能成為一個無與倫比的藝術家。生性善解人意、坦誠而迷人，喜歡羅曼蒂克的感覺。而且，極富同情心，樂於助人，喜歡奉獻，不會隨意傷人，看不得他人受到傷害，以及痛苦的表情。");
        title3.setText("行事風格：");
        content3.setText("你擅長抽象的思考，在藝術氣息良好的環境中能激發出你的創作靈感，不太喜歡規劃，從事與藝術相關的工作較能發揮你的潛能；注重內在感受及精神層面，對現實問題不太在乎；待人友善，沒有心機，人際關係良好。\n");
        title4.setText("個性盲點：");
        content4.setText("你喜歡幻想而容易變得多愁；想得過多有時會悲觀，缺乏自信及面對現實的勇氣，開創性不足；情緒變動劇烈，較感情用事，易給身邊的朋友帶來困擾；缺乏決斷力和意志力，常受外界干擾，反應力較弱。");
        title5.setText("總結：");
        content5.setText("雙魚座是十二宮最後一個星座，他集合了所有星座的優缺點於一身，同時受水象星座的情緒化影響，使他們原來複雜的性格又添加了更複雜的一筆。雙魚座的人最大的優點是有一顆善良的心，他們願意幫助別人，甚至是犧牲自己。");
    }
    public void aries(){
        imageView.setImageResource(R.drawable.aries);
        txvANS.setText("牡羊座");
        title1.setText("基本特質：");
        content1.setText("太陽位於牡羊座的人樂觀活潑、敢做敢當，幹勁十足，屬於劍及履及的行動派，是急行俠、探險家。但有時顯得沒有耐性，衝動易怒，太過冒險。");
        title2.setText("具體特質：");
        content2.setText("牡羊座是黃道十二宮的第一個星座，這讓你有著孩童般的純真、坦率，同樣，也有著與生俱來的創造力，表現出強烈的領導慾望及企圖心。太陽落在牡羊座的人是個急先鋒，以自我為中心，想到就出發，不愛猶豫；非常享受快節奏的生活步調，沖在最前面才最有優越感。牡羊座的主宰行星是火星，在火星的主導之下，羊族人活力充沛，不畏艱險；力爭前茅，惟有競爭才能讓你感覺到存在的價值；非常樂觀，不畏挫折，在人生的舞台上積極追求成功。");
        title3.setText("行事風格：");
        content3.setText("牡羊座是屬於春天的星座，在萬物復甦、春意盎然的季節出生，使得羊族人的體內充滿了冒險因子，精力旺盛，思維異常活躍；這些特質都使得你凡事都搶在最前面，一馬當先，開創力十足，讓人感覺不可超越；為了首開先河，甚至會鋌而走險，是個十足的開創型英雄。");
        title4.setText("個性盲點：");
        content4.setText("積極的另一面就是衝動、輕率，太愛冒險、思慮不周，很容易因此而陷入困境，人生大起大落，易把風險當機會；而直腸子的火爆性格常讓你得罪人而不自知。站得高、看得遠一點，行動前先思慮三秒，多站在他人的立場考慮問題，博採眾議、廣納雅言，這些都是羊族的子民們應努力修行的生命議題。");
        title5.setText("總結：");
        content5.setText("牡羊座有一種讓人看見就覺得開心的感覺，因為總是看起來都是那麼地熱情、陽光、樂觀、堅強，對朋友也慷慨大方，性格直來直往，就是有點小脾氣。牡羊男有大男人主義的性格，而牡羊女就是女漢子的形象。");
    }
    public void taurus(){
        imageView.setImageResource(R.drawable.taurus);
        txvANS.setText("金牛座");
        title1.setText("基本特質：");
        content1.setText("太陽位於金牛座的人給人的感覺穩重、務實，追求穩定與和諧，害怕變動，屬於享受派。喜歡安定，最怕沒有安全感。但有時顯得固執己見，對錢財看得很重。");
        title2.setText("具體特質：");
        content2.setText("太陽落在金牛座的人追求舒適的生活環境，嚮往高品質的生活，樂於追求金錢，對美好的物質享受充滿慾望。穩定和安全感是你衡量事物的唯一標準，是你執著的追求。做任何事若感覺仍有不確定因素存在，不會輕易地涉入，但一旦決心已定，將全力以赴，九頭牛也拉你不動。另外，你對於和身體相關的事物都很感興趣，包括性愛、飲食、運動等，欣賞一切美麗的事物。敏銳的洞察力也讓你很能了解他人的心思，是重感情的人。");
        title3.setText("行事風格：");
        content3.setText("你思慮周全，行事謹慎，擬定計劃是你的強項。在行動前就會考慮到前因後果，分析利弊，而後才會擇機小心翼翼地投入，要你打沒把握的仗比登天還難。");
        title4.setText("個性盲點：");
        content4.setText("你的賺錢慾望強烈，也易賺到錢，但也是一個十足的拜金主義者，易給人鐵公雞一毛不拔的印象，別把錢財看得太重；你行事過於謹慎，易錯過良機，應加強行動力，思慮太多易將動力消磨殆盡；有時顯得倔強，發起牛脾氣來還挺嚇人，稍加控制情緒，你的人際關係會更加圓融，提升貴人助力。\n");
        title5.setText("總結：");
        content5.setText("金牛座很保守，喜歡穩定，一旦有什麼變動就會覺得心裡不踏實，性格也比較慢熱，但你是理財高手，對於投資理財都有著獨特的見解。金牛男的性格有點兒自我，而金牛女就喜歡投資自己，想要過得更好。");
    }
    public void gemini(){
        imageView.setImageResource(R.drawable.gemini);
        txvANS.setText("雙子座");
        title1.setText("基本特質：");
        content1.setText("太陽位於雙子座的人，思維跳躍，口才伶俐，鬼點子多，常語出驚人，但有三心二意的傾向，情緒起伏多變，難以專心。");
        title2.setText("具體特質：");
        content2.setText("雙子座是黃道宮上的第三個星座，受水星守護，思維敏捷，有良好的溝通能力，反應迅速，適應力強。太陽落在雙子座的人追求並享受生動、多姿多彩、富於變化的生活環境，平淡、一成不變的環境難以引起你的興趣。因為你有很強的交際能力，所以身邊不缺朋友，風趣機智的表現也常受身邊人的歡迎。在好奇心的驅使下，你對新知有著強烈的求知欲，接受力強，因此儲備了滿腹的新知和話題，讓你頗有優越感。");
        title3.setText("行事風格：");
        content3.setText("處變不驚，“變”是你的永恆追求，越是變動的環境越能激起你的挑戰神經，如此才刺激，令你感到興奮，做起事來也更加的起勁。追求變化、有創意才是你的行事風格，為了達到效果，不惜誇大其辭。");
        title4.setText("個性盲點：");
        content4.setText("太陽位於雙子座的人具有雙重性格，情緒變化快速，做事有虎頭蛇尾的傾向，應加強耐性，培養靜心的功夫，更專心一些；因為想像力豐富，接收的訊息太多，使得你內心常處於矛盾狀態，常有令人不解的舉動；凡事據理力爭，太好辯，易與人發生言語衝突。");
        title5.setText("總結：");
        content5.setText("雙子座喜歡追求新鮮感，有點兒小聰明，就是耐心不夠，往往做事都是三分鐘熱度，難以堅持，但是你的可愛性格會讓很多人都喜歡跟你做朋友。雙子男錶面很花心，其實深情，而雙子女就喜歡求新和求變。");
    }
    public void cancer(){
        imageView.setImageResource(R.drawable.cancer);
        txvANS.setText("巨蟹座");
        title1.setText("基本特質：");
        content1.setText("太陽位於巨蟹座的人，親切有禮，感情豐富、細膩，有很強的感受力，具有母性的博愛之心，屬於居家派的。但情緒起伏，有逃避傾向。");
        title2.setText("具體特質：");
        content2.setText("巨蟹座是黃道宮上的第四個星座，主宰星為月亮。心思細密，感受力非常強，保護他人的意識強烈，家庭觀念濃厚，有強烈的責任心及犧牲奉獻精神。太陽落在巨蟹座的人擅長持家，喜歡安定祥和的家庭氛圍，對長輩孝順，對兄弟姐妹、朋友非常友善，努力創造你想要的和諧與美滿。當然，你的自我保護的意識也非常強烈，一點點的風吹草動都有可能讓你心潮起伏，當他人侵犯了你內心的那塊淨土時，你也會伸出鉗子示威。");
        title3.setText("行事風格：");
        content3.setText("你善於與人共事，凡事喜歡與人分享，行事謹慎，有自己的想法和追求，但不輕易表現出來，更希望他人能感受到你的內心想法。害怕競爭激烈的環境，在和樂的氣氛中做事，才能讓你感到安心，也能激發出你的潛能。");
        title4.setText("個性盲點：");
        content4.setText("自信、動力不足，遇到挫折易打退堂鼓；心靈較脆弱，經不起打擊，情緒低落，常沉迷於自我設想的悲傷裡；有逃避心理，害怕面對現實，情緒易跟著他人起舞，過度保護自己。應加強信心，多自我鼓勵，卸下心中的包袱。");
        title5.setText("總結：");
        content5.setText("巨蟹座的情緒容易敏感，也缺乏安全感，容易對一件事情上心，做事情有堅持到底的毅力，為人重情重義，對朋友、家人都特別忠實，巨蟹男是一等一的好男人，顧家愛家人，巨蟹女充滿母性光環，非常有愛心。");
    }
    public void leo(){
        imageView.setImageResource(R.drawable.leo);
        txvANS.setText("獅子座");
        title1.setText("基本特質：");
        content1.setText("太陽位於獅子座的人，自信自強，氣度非凡，極具領導統御能力，永不服輸，是天生的貴族、王者。只是有時過度追求利，甚至有些自負，莽撞、以自我為中心。");
        title2.setText("具體特質：");
        content2.setText("獅子座是黃道宮上的第五個星座，主宰星為太陽。陽光燦爛，充滿活力，感覺有用不完的能量；表現欲強烈，舉手投足之間充滿了閃耀的魅力，很容易成為眾人矚目的焦點，你身上散發出來的熱力很容易感染周圍的人，讓大家跟著你一起舞動生活。你對權力地位的追求非常執著，以捍衛你的領導地位，而這也是你不斷向前的動力泉源。這往往讓你站得比別人高，獲得也比別人多，但人生大起大落；自尊心很強，當追求無望時會變得沉淪、怠惰。");
        title3.setText("行事風格：");
        content3.setText("有話直說，直截了當，從不拐彎抹角，胸懷坦蕩；在工作上展現出高度的自信，做事雷厲風行，挑戰權威，在挑戰中尋求刺激，獲得成就感；待人大方慷慨，野心勃勃，喜歡被人推崇、膜拜，無人關注會感失落。");
        title4.setText("個性盲點：");
        content4.setText("慾望太強，太重面子，得失心較重，驕傲自負，這會讓你變得孤立無援；太愛冒險，甚至魯莽，易損失慘重。捨棄得失心，平和及定性是你需要加強的修為。");
        title5.setText("總結：");
        content5.setText("獅子座有著宏偉的理想，總想靠自己的努力成為人上人，你嚮往高高在上的優越感，也期待被仰慕被崇拜的感覺，有點兒自信有點兒自大。獅子男的大男人氣息很重，愛面子，獅子女熱情陽光，對朋友講義氣。");
    }
    public void virgo(){
        imageView.setImageResource(R.drawable.virgo);
        txvANS.setText("處女座");
        title1.setText("基本特質：");
        content1.setText("太陽位於處女座的人，思慮周全，非常謙虛，謹慎保守，很有耐心，擅長分析，凡事要求做到盡善盡美，是個完美主義者。但易給人較大的壓力，較被動嚴肅。");
        title2.setText("具體特質：");
        content2.setText("處女座是黃道宮的第六個星座，主宰星為水星。思路清晰，冷靜理性，待人真誠，但保持一定的距離；對自我要求甚高，腳踏實地默默努力，以達成目標，構築更美好的生活。受到主宰星水星的影響，你獨立，思維敏捷，樂於為人服務，易受人歡迎。生活態度嚴謹，要求一絲不苟，有自己的道德底線，不會亂來；喜歡安靜舒適的環境，最怕無序、雜亂無章；你也希望獲得周圍人的肯定，聽到認同的聲音你會更有鬥志。");
        title3.setText("行事風格：");
        content3.setText("太陽落在處女座的人做事條理分明，不急躁，穩步前進；細膩的思路和謹慎、耐心的行事作風，讓你很容易成為優秀者，在群體中脫穎而出。求知慾望強烈，覺得沒有知識是很丟人的事，會拚命地充實自我。");
        title4.setText("個性盲點：");
        content4.setText("太過要求完美，心理承受著較大的壓力，容易自我設限，不易放開胸懷；太過小心翼翼，有矯枉過正的嫌疑；太注重細節，往往見樹不見林。應釋放壓力，開闊胸襟，多與人群接觸，交流互動可讓你收穫更多。");
        title5.setText("總結：");
        content5.setText("處女座雖然常常被黑，但你還是依然堅持追求自己的完美主義，因為在你看來，生活不能將就，追求的完美更不能將就，有目標才有進步，當然也需要鼓勵。處女男的毅力很強，能堅持，處女女的求知欲很強。");
    }
    public void libra(){
        imageView.setImageResource(R.drawable.libra);
        txvANS.setText("天秤座");
        title1.setText("基本特質：");
        content1.setText("太陽位於天秤座的人很有氣質，談吐應對得體，善於與人溝通協調，是絕佳的談判人才，屬於迷人優雅派人物。只不過，思想易左右搖擺；追求外表光鮮，易失去自我。");
        title2.setText("具體特質：");
        content2.setText("天秤座是黃道宮上的第七個星座，主宰星為金星。你極具風度，渾身充滿了優雅的貴族氣息，喜歡與人群接觸，不喜歡單打獨鬥，對於具有美感的事物特別感興趣，出色的交際能力讓你很容易與人打成一片；你很注意自己的外在形象，希望在他人面前表現出完美的一面，但也易讓人感覺虛榮、做作。你喜歡從正反兩面看待問題，力求公平公正，最怕衝突和不協調；有一套自己人生哲學，懂得享受生活。");
        title3.setText("行事風格：");
        content3.setText("太陽落在天秤座的你，凡事要求公平，遇事從多角度思考，以達到你所追求的平等；熱衷於團隊合作，在輕鬆愉快的環境中工作可以激發出你的熱情，會有非常出色的表現。只是有時太追求平衡，反而難以達到更好的效果。");
        title4.setText("個性盲點：");
        content4.setText("有時神經過敏，顯得神經質，常常處於焦慮不安的狀態；意志薄弱，遇事搖擺不定，難以抉擇，常給人瞻前顧後的印象，顯得懦弱。應放鬆身心，釋放壓力，增強魄力與行動力，快速作出決定。");
        title5.setText("總結：");
        content5.setText("天秤座常常追求平等、和諧，擅於察言觀色，交際能力很強，因此真心朋友不少，因為你也足夠真誠，但是最大的缺點就是面對選擇總是猶豫不決。天秤男容易在乎自己而忽略別人，天秤女就喜歡被陪伴的感覺。\n");
    }
    public void scorpio(){
        imageView.setImageResource(R.drawable.scorpio);
        txvANS.setText("天蠍座");
        title1.setText("基本特質：");
        content1.setText("太陽位於天蠍座的人，外表低調，實則企圖心旺盛，充滿神秘感，不會輕易地與人互動。對自我要求很高，極具競爭力與戰鬥力，有洞悉他人心思的能力。");
        title2.setText("具體特質：");
        content2.setText("天蠍座是黃道宮上的第八個星座，主宰星為冥王星，能量強大、精力旺盛，有強烈責任感，韌性強、黑白分明、意志力強、支配欲強烈，對於生命的奧秘有獨特的見解。你的城府頗深，待人處事非常冷靜理性，不苟言笑，有著強烈的第六感，以及神秘的吸引力，雖然有著敏銳的觀察力，但往往仍靠感覺來決定一切。你深沉的面孔常讓身邊的人感到不舒服，對你敬而遠之；很懂得察言觀色，但討厭他人探聽你的內心世界。");
        title3.setText("行事風格：");
        content3.setText("凡事自有主張，三思而後行，有著謹慎、冷靜的行事風格，非常注重過程，在設想、架構上會花費較多的時間和精力。工作冷靜理性，意志堅定，設立目標後不會輕易放棄，會用穩紮穩打的方式實現目標。");
        title4.setText("個性盲點：");
        content4.setText("有孤僻的傾向，不喜歡與人過深的交往，相較於群體活動，更喜歡享受一個人的獨處；對他人有不信任感，凡事親力親為；較孤傲，表現出很強的戒備心，令人難以親近。應消除顧忌，再果敢開放一些，拓展人脈，你的人生格局才會更大。");
        title5.setText("總結：");
        content5.setText("天蠍座精力旺盛、佔有欲極強，對於生活很有目標，不達到目的誓不罷休，復仇心理重，記仇會讓自己不顧一切報復曾經傷害過你的人。天蠍男自我主義色彩很強烈，天蠍女的自我保護意識很強，不容易接近。");
    }
    public void sagittarius(){
        imageView.setImageResource(R.drawable.sagittarius);
        txvANS.setText("射手座");
        title1.setText("基本特質：");
        content1.setText("太陽位於射手座的人，生性樂觀開朗，熱情奔放，崇尚自由，反應靈敏，極具創造力。待人友善又極具豪氣，作風非常海派，人緣頗佳。");
        title2.setText("具體特質：");
        content2.setText("射手座是黃道宮上的第九個星座，主宰星為木星。有著輕鬆愉快、活潑開朗的人生觀。太陽落在射手座，做人非常坦蕩，待人真誠熱情，積極樂觀的一面很吸引人，非常受人歡迎。你屬於樂觀、坦率、聰慧的類型，喜歡特立獨行，頗富直覺與鼓舞他人的力量，思想開明、適應力強，不拘小節，生性幽默，很懂得享受生活。對你而言，生活就是一連串的探險，喜歡追求新奇有趣的經驗。");
        title3.setText("行事風格：");
        content3.setText("你很夠朋友、講義氣，朋友遍天下，四處有貴人；精力充沛，做事效率高，可以身兼數職，但常常是虎頭蛇尾，易半途而廢；愛冒險，行動敏捷。");
        title4.setText("個性盲點：");
        content4.setText("你有時做事稍欠考慮，有過於草率之嫌；不守規則，有時還會幽默過頭，或是說話太過直接，得罪人而不自知；太過自由，顯得散漫；做事求快而不注重細節，易出錯，有時還顯得三心二意，非常粗心。");
        title5.setText("總結：");
        content5.setText("射手座崇尚自由，勇敢、果斷、獨立，身上有一股勇往直前的勁兒，不管有多困難，只要想，就能做，你的毅力和自信是難以擊倒的。射手男酷愛自由，討厭被束縛，射手女性格簡單直接，不耍心計，可是任性。");
    }
    public void capricorn(){
        imageView.setImageResource(R.drawable.capricorn);
        txvANS.setText("摩羯座");
        title1.setText("基本特質：");
        content1.setText("太陽位於摩羯座的人，很有自己的想法，很注重實際，耐力十足，意志堅定，有很強的時間觀念，重視權威和名聲，有不錯的組織領導能力，是值得依賴的人。");
        title2.setText("具體特質：");
        content2.setText("摩羯座是黃道宮上的第十個星座，主宰星為土星，有著成熟認真的人生觀。太陽落在摩羯座的人，就像將領，能擔當大任，追求高難度的理想，喜歡控制全局，善於獨立實現自己心中的理想。喜歡從容不迫、深思熟慮，待人親切和藹、心胸寬廣、有抱負，以踏實的方式追求成功，信奉有付出就會有回報的信條。一步一個腳印，即使遇到挫折也能堅持下去，頑強的毅力及耐力是你邁向成功的不二法門。");
        title3.setText("行事風格：");
        content3.setText("你做事腳踏實地，行事低調深沉，竭盡全力去超越跑在前面的人，不會存有僥倖心理。善於計劃，而且按部就班的執行；任何事都講求公平合理，凡事能運籌帷幄，從一而終，令人放心且欣賞。");
        title4.setText("個性盲點：");
        content4.setText("你比較嚴肅，不容易親近；有時過於堅持己見，會有點頑固；內心有著極度的不安全感，對他人不太信任；情緒較壓抑，容易給自己施加太大的壓力。應放輕鬆一些，別讓神經總是處於緊張狀態，休息才能走更長遠的路。\n");
        title5.setText("總結：");
        content5.setText("摩羯座是十二星座中最有耐心，為事最小心、也是最善良的星座。他們做事腳踏實地，也比較固執，不達目的是不會放手的。他們的忍耐力也是出奇的強大，同時也非常勤奮。他們心中總是背負著很多的責任感，但往往又很沒有安全感，不會完全地相信別人。");
    }



    //已關閉此activity作為返回
    public void back(View view){finish();}
}

