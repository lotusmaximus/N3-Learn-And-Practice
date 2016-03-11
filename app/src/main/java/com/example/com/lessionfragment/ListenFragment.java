package com.example.com.lessionfragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.com.myapplication.MainActivity;
import com.example.com.myapplication.R;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by 8470p on 2/18/2016.
 */
public class ListenFragment extends android.support.v4.app.Fragment {
    int activity;
    ImageView play,pause;
    private View mFab;
    private FrameLayout mFabContainer;
    private LinearLayout mControlsContainer;

    public final static float SCALE_FACTOR      = 13f;
    public final static int ANIMATION_DURATION  = 300;
    public final static int MINIMUN_X_DISTANCE  = 200;

    private boolean mRevealFlag;
    private float mFabSize;
    public ListenFragment(int activity) {
        this.activity = activity;
    }
    MediaPlayer mediaPlayer;
    TextView textView;
    View rootView;

    Handler mHandler = new Handler() {
        @Override
        public void close() {

        }

        @Override
        public void flush() {

        }

        @Override
        public void publish(LogRecord record) {

        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lession_listen,container,false);
        setTextandMedia();
        play = (ImageView) rootView.findViewById(R.id.play);
        pause = (ImageView) rootView.findViewById(R.id.pause);


        final SeekBar seekBar = (SeekBar) rootView.findViewById(R.id.seekbar);
        final android.os.Handler handler = new android.os.Handler();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                }
                handler.postDelayed(this,1000);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mediaPlayer != null && fromUser) {
                    mediaPlayer.seekTo(progress * 1000);
                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                pause.setVisibility(View.VISIBLE);
                play.setVisibility(View.GONE);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                pause.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                pause.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
            }
        });
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible()){
            if(!isVisibleToUser&&mediaPlayer!=null&&pause!=null&&play!=null){
                mediaPlayer.pause();

            }
        }
    }

    @Override
    public void onPause() {
        mediaPlayer.pause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mediaPlayer.pause();
        super.onStop();
    }
    public void setTextandMedia(){
        textView = (TextView) rootView.findViewById(R.id.text);
        switch (activity){
            case 1:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession1);
                textView.setText("音楽と音の効果\n" +
                        "疲れたとき、 寂しいとき、 ストレスがたまったときに、 音楽を聞いて、 気持ちをリラックスさせるという人が多い。 \n" +
                        "わたしたちは好きな音楽を聞くと、 心が落ち着いたり、 寂しさを忘れたりする。 また自然の中の音、 例えば波の音、\n" +
                        "小鳥の鳴き声を聞いて心がいやされたりする。 このように音楽、 音の効果を利用してストレス解消や体を元気にすることを 「音楽療法」 という。\n" +
                        "「音楽療法」 の方法はさまざまで、 音楽を聞く、 歌を歌う、 歌に合わせて手遊びをする、 楽器を演奏するなどがある。 最も簡単な方法は「 聞く」 ことだろう。\n" +
                        "では、 どんな音楽を聞いたらいいのだろうか。 嫌いな音楽を聞いてもリラックスできるわけがない。 自分の好きな音楽を聞くことこそ、心のいやしになるのである。 \n" +
                        "したがって、 クラシックが好きな人はクラシックを、 演歌が好きな人は演歌を聞くのが効果的な方法だ。\n" +
                        "また、 ことばでコミュニケーションをとるのが難しい人が、 音楽療法士と一緒に歌ったり、 演奏したりして、 次第にコミュニケーションがとれるようになった事例がある。\n" +
                        "ストレスの多い現代社会に音楽。音がどのような効果をもたらすか、 今後より注目されていくだろう。");
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession2);
                textView.setText("いい数字。 悪い数字\n" +
                        "あなたの国ではどんな数字が　「いい数字」 で、 反対にどんな数字が　「悪い数字」 だと考えられていますか。下の表を見てください。\n" +
                        "\n" +
                        "いい数字悪い数字ベトナム偶数（ 2-4-6-8） 。  9 |奇数（ 1-3-5-7） 日本4。9中国語圏6。8。9\n" +
                        "\n" +
                        "ベトナムでは、 「4」 という数字はいい数字の1つだと考えられています。偶数は仲間がいるという理由でいい数字なのです。しかし日本や中国語圏では　「4」 は　「死」 と音が同じだという理由で嫌われています。国によって、 縁起のいい数字.悪い数字は異なっているのです。　\n" +
                        "しかし、 中国語圏ほど　「いい数字」 にこだわるところはないようです。車につけるナンバーを例にとって紹介しましょう。 香港では発音するといい意味になるナンバー、 例えば　「必ず金持ちになる」 という意味の　「1818」 は、オークションで数百万円から数千万円というびっくりするぐらいの値段がつくこともあるそうです。日本では抽選に当たれば、人気がある番号　（1　や　8888　など） を手数料だけで手に入れることができますから、日本人からすると考えられないことです。　香港ではどんな車を持っているかより、 どんな番号のプレートをつけているかを重要視する人がいるようです。");
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession3);
                textView.setText("");
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession4);
                textView.setText("くしゃみ\n" +
                        "よく晴れた日に空を見上げると、 「はくしょん」 とくしゃみが飛びだすことがある.\n" +
                        "本来、 くしゃみは、 鼻に入った異物を発作的に外に押しだそうとして起こる反射運動である。 ほこりなどが鼻に入ったり、 冷たい空気を吸い込んだりすることがきっかけになるそうだ。 しかし、 空を見上げて出るくしゃみは光の反射運動だ。 光を取り込んでいる器官は鼻ではなく、 「目」 なのに、 なぜくしゃみが起こるのだろうか。 \n" +
                        "目からの 「まぶしい」 という刺激が、 脳に伝わる途中で、 なぜか鼻からの刺激と受け取られるからだ。つまり 「神経の誤作動」 である。 昼間、 映画館から外へ出たとたんに、 くしゃみが起こるのも同じ理由だ。 国内外の調査では2、3割の人に自覚症状があると言われる。 \n" +
                        "ところで、 日本語でくしゃみを表す音は 「はくしょん」 が一般的だが、 実際の音はどうだろうか。 「へっくしゅ」 「 はっくしょい」 「くしゅん」 など、 人によってさまざまである。 おもしろいことに、 くしゃみの音が親子でそっくりであるとか、 くしゃみのしかたに男女差があると言われることもあり、 くしゃみは社会学的にも興味深い生理現象である。");
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession5);
                textView.setText("わたしの町\n" +
                        "\n" +
                        "9月の半ばを過ぎ、 朝晩幾分涼しくなって過ごしやすくなりました。 \n" +
                        "わたしの住むアパートの近くに三井公園という公園があります。　ァパートから歩いて公園を一周して帰ってくると45分ぐらい。 ちょうどいい散歩コースなので、 休日の朝、 よく行きます。 その三井公園も秋の気配を見せつつあります。\n" +
                        "その公園を紹介します。\n" +
                        "最初の写真は公園の入り口から撮ったものです。 この公園は自転車の通り抜け禁止なので、 入口に自転車進入止めが作られています。\n" +
                        "公園は大小2つの池を中心に造られています。この写真は小さいほうの池です。 この池のほうが大きい池より自然に近く、 静かなたたずまいを漂わせています。\n" +
                        "池沿いの小道を少し行ったところにベンチがあります。　落ち葉がいっぱいで何だか秋らしい景色でしょう。 このベンチに座って、 秋の日を浴びながら読書している人をよく見かけます。\n" +
                        "最後の写真は、 子供たちが楽しげに遊んでいるものです。 \n" +
                        "公園は息抜きに訪れる人が多いので、 穏やかな空気に包まれています。 住まいの近くにこういう公園があるのは幸せなことです。");
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession6);
                textView.setText("");
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession7);
                textView.setText("");
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.lession8);
                textView.setText("");
                break;
        }
    }
}
