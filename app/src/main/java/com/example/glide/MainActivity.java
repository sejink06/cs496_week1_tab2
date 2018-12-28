package com.example.glide; // com.androidglide

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.glide.R;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        image = findViewById(R.id.image);

        //load image on button click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urls = "https://news.nationalgeographic.com/content/dam/news/2018/05/17/you-can-train-your-cat/02-cat-training-NationalGeographic_1484324.ngsversion.1526587209178.adapt.1900.1.jpg\n" +
                        "http://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg\n" +
                        "https://static.boredpanda.com/blog/wp-content/uploads/2018/04/5acb63d83493f__700-png.jpg\n" +
                        "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80\n" +
                        "https://www.catster.com/wp-content/uploads/2018/07/Savannah-cat-long-body-shot.jpg\n" +
                        "https://www.bluecross.org.uk/sites/default/files/assets/images/124044lpr.jpg\n" +
                        "https://media.mnn.com/assets/images/2018/07/cat_eating_fancy_ice_cream.jpg.838x0_q80.jpg\n" +
                        "https://cdn-images-1.medium.com/max/1600/1*mONNI1lG9VuiqovpnYqicA.jpeg\n" +
                        "https://r.hswstatic.com/w_907/gif/tesla-cat.jpg\n" +
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg\n" +
                        "http://www.petmd.com/sites/default/files/what-does-it-mean-when-cat-wags-tail.jpg\n" +
                        "https://www.readersdigest.ca/wp-content/uploads/sites/14/2011/01/4-ways-cheer-up-depressed-cat.jpg\n" +
                        "https://images.immediate.co.uk/volatile/sites/4/2018/08/iStock_000044061370_Medium-fa5f8aa.jpg?quality=45&crop=5px,17px,929px,400px&resize=960,413\n" +
                        "http://www.gannett-cdn.com/-mm-/421fa88894207f6fd125837bfbea3a215d8338a7/c=972-205-2409-1017/local/-/media/2016/10/18/USATODAY/USATODAY/636124053572235005-101816orange-cat-thinkstock.jpg?width=3200&height=1680&fit=crop\n" +
                        "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg\n" +
                        "https://www.rd.com/wp-content/uploads/2016/04/01-cat-wants-to-tell-you-laptop.jpg\n" +
                        "https://pbs.twimg.com/profile_images/378800000532546226/dbe5f0727b69487016ffd67a6689e75a_400x400.jpeg\n" +
                        "http://www.catster.com/wp-content/uploads/2017/08/Pixiebob-cat.jpg\n" +
                        "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cat-quotes-1543599392.jpg\n" +
                        "https://www.usmagazine.com/wp-content/uploads/2018/06/Smoothie-the-Cat-Instagram-zoom.jpg\n" +
                        "https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?cs=srgb&dl=animal-cat-cute-45201.jpg&fm=jpg\n" +
                        "https://amp.businessinsider.com/images/5654150584307663008b4ed8-750-563.jpg\n" +
                        "https://i.ytimg.com/vi/lrvqjdMcjjQ/hqdefault.jpg\n" +
                        "https://images.mentalfloss.com/sites/default/files/styles/mf_image_16x9/public/munchkinhed.png?itok=oeH4evcQ&resize=1100x1100\n" +
                        "http://r.ddmcdn.com/s_f/o_1/cx_462/cy_245/cw_1349/ch_1349/w_720/APL/uploads/2015/06/caturday-shutterstock_149320799.jpg\n" +
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Gatto_europeo4.jpg/250px-Gatto_europeo4.jpg\n" +
                        "https://timedotcom.files.wordpress.com/2014/12/ap1109280145869.jpg\n" +
                        "https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg\n" +
                        "https://timedotcom.files.wordpress.com/2018/08/new-zealand-cat-ban.jpg\n" +
                        "https://s.hswstatic.com/gif/whiskers-sam.jpg\n" +
                        "http://honesttopaws.com/wp-content/uploads/sites/5/2017/05/banana-cat-1.png\n" +
                        "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?cs=srgb&dl=animal-animal-photography-cat-104827.jpg&fm=jpg\n" +
                        "https://www.royalcanin.com/~/media/Royal-Canin/Product-Categories/cat-adult-landing-hero.ashx\n" +
                        "https://www.argospetinsurance.co.uk/assets/uploads/2017/10/pexels-photo-416160.jpeg\n" +
                        "https://www.dw.com/image/42519102_303.jpg\n" +
                        "https://images.pexels.com/photos/326875/pexels-photo-326875.jpeg?cs=srgb&dl=adorable-animal-blur-326875.jpg&fm=jpg\n" +
                        "https://img-aws.ehowcdn.com/600x600p/photos.demandstudios.com/getty/article/165/76/87490163.jpg\n" +
                        "https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/08/30/11/cat-bird.jpg\n" +
                        "https://static1.squarespace.com/static/5910d4dfe6f2e150b0706e20/t/5915d700bebafb09be8e8cf5/1494603730676/siamesewalking.png?format=1500w\n" +
                        "https://lookaside.fbsbx.com/lookaside/crawler/media/?media_id=188509415061350\n" +
                        "https://www.humanesociety.org/sites/default/files/2018/06/cat-217679.jpg\n" +
                        "https://boygeniusreport.files.wordpress.com/2017/01/cat.jpg?quality=98&strip=all&w=782\n" +
                        "https://i.ytimg.com/vi/6Yt3mMBmm3M/maxresdefault.jpg\n" +
                        "https://www.purina.co.uk/sites/g/files/mcldtz776/files/2017-11/How-old-is-my-cat-in-human-years_0.jpg\n" +
                        "https://thewirecutter.com/wp-content/uploads/2018/07/catadoption-lowres-06052-2x1-1.jpg\n" +
                        "https://amp.thisisinsider.com/images/5b840a0d3cccd123008b458c-750-562.jpg\n" +
                        "https://i.amz.mshcdn.com/cQ4-JZvF7gUQHPLMlN8o-D279cM=/fit-in/1200x9600/https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com%2Fuploads%2Fcard%2Fimage%2F784547%2F0c47ef8e-b577-4e31-97ab-f604315e050c.jpg\n" +
                        "https://upload.wikimedia.org/wikipedia/commons/6/69/June_odd-eyed-cat_cropped.jpg\n" +
                        "http://images.ctfassets.net/e43mbx7oxv8s/dTeQVZbR72uiYkEAYKyUS/bd3825a93aace2c7b368a7a742b1000f/000122_ZV_SCSW_HeroImages_1900x1024_D1.jpg\n" +
                        "https://d17fnq9dkz9hgj.cloudfront.net/uploads/2012/11/152964589-welcome-home-new-cat-632x475.jpg\n" +
                        "https://www.economist.com/sites/default/files/20171216_BKP511_0.jpg\n" +
                        "http://www.catster.com/wp-content/uploads/2017/10/A-kitten-meowing-with-his-mouth-open.jpg\n" +
                        "https://www.edch.org.uk/sites/default/files/content-blocks/catsnew.jpg\n" +
                        "https://images-production.freetls.fastly.net/uploads/posts/off_site_promo_image/166842/why-do-cats-meow.jpg?auto=compress&crop=top&fit=crop&q=55&w=1200&h=900\n" +
                        "http://sciencenordic.com/sites/default/files/imagecache/620x/kat_astma_videnskab.jpg\n" +
                        "http://www.royalcanin.ca/~/media/Royal-Canin-Canada/Product-Categories/cat-adult-landing-hero.ashx\n" +
                        "https://www.telegraph.co.uk/content/dam/news/2017/09/08/TELEMMGLPICT000138582248-xlarge_trans_NvBQzQNjv4BqLODrYCEVrDwzaY_adYCJ4iVEeSQZANxeMT4D58rU5LA.jpeg\n" +
                        "https://images.unsplash.com/photo-1519052537078-e6302a4968d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80\n" +
                        "https://www.rspcansw.org.au/wp-content/uploads/2017/08/72_a-feature_cats-and-kittens_mobile.jpg\n" +
                        "https://thumbs.mic.com/OTg5ZmJiYmM1YyMvaE8xVS0tenRsM2pYYUtQaU5xekZoZEticUtRPS83eDEyNjozNTAweDIzMjkvODAweDQ1MC9maWx0ZXJzOmZvcm1hdChqcGVnKTpxdWFsaXR5KDgwKS9odHRwczovL3MzLmFtYXpvbmF3cy5jb20vcG9saWN5bWljLWltYWdlcy9hMTI1YWUwNDAyMDc2YzZjZmNmOGE5ODczZmVmMzZjMDAzOTAxNWMzZTc4NzBmY2M0N2Q3OGM3YmJkMDVjNmM5LmpwZw.jpg\n" +
                        "https://i.kinja-img.com/gawker-media/image/upload/s--Q4WTuzbO--/c_fill,f_auto,fl_progressive,g_north,h_264,q_80,w_470/lltozqbgqulk1rjoctzu.jpg\n" +
                        "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201601/cat---facebook-and-storysize_647_011416045855.jpg\n" +
                        "https://catscornervet.com/wp-content/uploads/2016/04/kitty-1.png\n" +
                        "https://thechive.files.wordpress.com/2018/04/s4fo1gdqivnxfk0wsx6injr_zjpjhzdjz1eop9jjsae-copy.jpg?quality=85&strip=info&w=600\n" +
                        "http://mymodernmet.com/wp/wp-content/uploads/2017/11/chimera-cat-quimera-1.jpg\n" +
                        "https://thewirecutter.com/wp-content/uploads/2018/04/catbeds-2x1-05936.jpg\n" +
                        "https://i.ytimg.com/vi/5dsGWM5XGdg/hqdefault.jpg\n" +
                        "https://www.bluecross.org.uk/sites/default/files/styles/thumbnail_pet/public/pets/240143/491286.jpg?itok=2_vNAIUp\n" +
                        "http://static.digg.com/images/9b59a2098e9a4f32970a4aec98211319_99da8394349e994abea3dcd167806e6d_1_www_vid_large_thumb.jpeg\n" +
                        "https://atlantahumane.org/wp-content/uploads/2012/08/adopt-a-cat-1200x630.png\n" +
                        "https://image.nj.com/home/njo-media/width620/img/entertainment_impact/photo/lil-bub-catsbury-park-cat-convention-asbury-park-2018jpg-42ba0699ef9f22e0.jpg\n" +
                        "https://i.kym-cdn.com/entries/icons/original/000/026/638/cat.jpg\n" +
                        "https://wi-images.condecdn.net/image/26lrrvzLjpx/crop/405/f/gettyimages-161785570.jpg\n" +
                        "https://www.gannett-cdn.com/-mm-/735f994d042682a89f8a4f2fcfd5ea505f3dc1cd/c=0-127-2995-1819/local/-/media/2015/10/31/USATODAY/USATODAY/635818943680464639-103115cute-kitty.jpg?width=3200&height=1680&fit=crop\n" +
                        "https://ichef.bbci.co.uk/news/660/cpsprodpb/FDD6/production/_100728946_catrelax.jpg\n" +
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/White_Persian_Cat.jpg/220px-White_Persian_Cat.jpg\n" +
                        "https://theorphanpet.com/wp-content/uploads/2016/06/13233136_788779574558512_3397930498291044113_n.jpg\n" +
                        "https://localtvkstu.files.wordpress.com/2018/02/turtle-the-cat-1.jpg?quality=85&strip=all&w=2000\n" +
                        "https://cdn5.img.sputniknews.com/images/105967/95/1059679556.jpg\n" +
                        "https://peopledotcom.files.wordpress.com/2018/10/cat1.jpg\n" +
                        "https://twistedsifter.files.wordpress.com/2014/10/chin-fur-makes-cat-look-surprised-banye-china-5.jpg?w=800&h=533\n" +
                        "https://cdn.images.express.co.uk/img/dynamic/128/590x/Cat-1020489.jpg?r=1537461428357\n" +
                        "https://thewirecutter.com/wp-content/uploads/2018/06/cataccessories-lowres-2x1-05916.jpg\n" +
                        "https://media.socastsrm.com/wordpress/wp-content/blogs.dir/348/files/2018/08/12920541_1345368955489850_5587934409579916708_n-2-960x410-1.jpg\n" +
                        "https://cdn.bestfriends.org/s3fs-public/Introducing-New-Cat-Bagels-Quiche-8265SAx.jpg?6c.USkb3JCMmg1ukQJzQbNozWQ1eUXT0\n" +
                        "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/kitten-playing-with-toy-mouse-royalty-free-image-590055188-1542816918.jpg\n" +
                        "https://www.gannett-cdn.com/-mm-/4a9f3ddc8f1dae539e5301fb8821077a1ffacfdc/c=99-0-401-170/local/-/media/2018/05/14/USATODAY/usatsports/wp-USAT-allthemoms-front1-17730-cat.png?width=580&height=326&fit=crop\n" +
                        "https://cat-bounce.com/catbounce.png\n" +
                        "https://www.petmd.com/sites/default/files/petmd-cat-happy-13.jpg\n" +
                        "https://media.mnn.com/assets/images/2018/07/cat_one_eye_open.jpg.838x0_q80.jpg\n" +
                        "https://www.newsobserver.com/latest-news/xm78bk/picture209017294/alternates/FREE_1140/29597333_10155404324631186_359612486424514144_n.jpg\n" +
                        "https://static.independent.co.uk/s3fs-public/thumbnails/image/2016/02/25/13/cat-getty_0.jpg?w968h681\n";
                String[] parts = urls.split("\n");
                Glide.with(MainActivity.this).load(parts[0]).into(image);
            }
        });
    }
}