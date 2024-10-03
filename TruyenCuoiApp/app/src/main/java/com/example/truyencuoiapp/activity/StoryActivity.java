package com.example.truyencuoiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.truyencuoiapp.R;
import com.example.truyencuoiapp.adapter.CategoryAdapter;
import com.example.truyencuoiapp.adapter.StoryAdapter;
import com.example.truyencuoiapp.model.Category;
import com.example.truyencuoiapp.model.Story;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity {
    RecyclerView rvStory;
    StoryAdapter adapterStory;
    ArrayList<Story> listStory;
    ArrayList<Story> listStorybyCategoryID;
    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_activity);
        rvStory = findViewById(R.id.rv_story);
        iv = findViewById(R.id.iv);
        tv =  findViewById(R.id.tv_name);

        listStory = new ArrayList<>();
        listStorybyCategoryID = new ArrayList<>();
        listStory.add(new Story(1,1,"Việc học","Cô gái hỏi bạn:\n" +
                "\n" +
                "\"Cậu ơi, cậu học bài cho kiểm tra chưa?\"\n" +
                "Bạn trai đáp:\n" +
                "\n" +
                "\"Chưa, mình chưa thấy tài liệu nào hay.\"\n" +
                "Cô gái liền nói:\n" +
                "\n" +
                "\"Vậy mình sẽ gửi cho cậu một cuốn sách 'Học không bao giờ là đủ' nhé!\"\n" +
                "Bạn trai ngạc nhiên:\n" +
                "\n" +
                "\"Sao lại vậy?\"\n" +
                "Cô gái cười:\n" +
                "\n" +
                "\"Vì cậu học mãi mà vẫn không có kiến thức thì 'đủ' đâu được!\""));
        listStory.add(new Story(2,1,"Đã hai lần rồi","Lần 1: Chỉnh sửa đầu tiên\n" +
                "\n" +
                "Ở một làng nhỏ có một chú mèo tên là Miu. Miu rất đặc biệt, vì chú không chỉ thích ngủ và ăn như những chú mèo khác, mà còn thích nói chuyện. Mỗi khi chủ nhà gọi Miu, chú sẽ trả lời bằng những câu chuyện hài hước về cuộc sống hàng ngày của mình. Một hôm, chủ nhà tổ chức một buổi tiệc và mời rất nhiều người đến.\n" +
                "\n" +
                "Miu đã quyết định biểu diễn một tiết mục hài hước. Chú đứng lên trên bàn và bắt đầu kể những câu chuyện thú vị về những lần chú đi bắt chuột, những lần chú bị nước tạt vào mặt và cả những lần chú đuổi theo chiếc đuôi của mình. Mọi người đều cười vang, và buổi tiệc trở nên vui vẻ hơn bao giờ hết.\n" +
                "\n" +
                "Lần 2: Chỉnh sửa thứ hai\n" +
                "\n" +
                "Ở một làng nhỏ có một chú mèo tên là Miu. Miu rất đặc biệt, không chỉ thích ngủ và ăn như những chú mèo khác, mà còn thích nói chuyện. Mỗi khi chủ nhà gọi Miu, chú sẽ trả lời bằng những câu chuyện hài hước về cuộc sống của mình. Một hôm, chủ nhà tổ chức một buổi tiệc và mời rất nhiều người đến.\n" +
                "\n" +
                "Miu đã quyết định biểu diễn một tiết mục hài hước. Chú nhảy lên bàn tiệc và bắt đầu kể những câu chuyện thú vị về những lần chú đi bắt chuột, những lần bị nước tạt vào mặt, và cả những lần đuổi theo chiếc đuôi của mình. Mọi người đều cười ngả nghiêng, và buổi tiệc trở nên náo nhiệt hơn bao giờ hết. Sau đó, ai cũng muốn có Miu làm vật phẩm trang trí cho các buổi tiệc sau này!"));
        listStory.add(new Story(3,1,"Cũng như nhau","Có một con gà tên là Gà Gô. Gà Gô không biết gáy như những con gà khác mà lại thích hát nhạc rap. Một ngày, Gà Gô quyết định tham gia cuộc thi tài năng trong làng.\n" +
                "\n" +
                "Khi đến lượt mình, Gà Gô đứng lên và bắt đầu rap: \"Gà Gô đây, không giống ai, chạy nhảy khắp nơi, không biết sợ trời!\" Mọi người trong làng cười nghiêng ngả, và cuối cùng, Gà Gô đã thắng giải nhất! Từ đó, Gà Gô trở thành ngôi sao rap của làng."));
        listStory.add(new Story(4,1,"Rất lạnh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,1,"Im lặng là vàng","Bà Bà Gà và Bà Bà Mèo tranh cãi xem ai là người chăm sóc tốt nhất cho các con của mình. Bà Bà Gà nói: \"Tôi dạy gà con biết bơi!\" Bà Bà Mèo đáp: \"Thế thì tôi dạy mèo con biết leo cây!\" Cuối cùng, cả hai quyết định dạy nhau, và kết quả là gà con bơi rất giỏi, còn mèo con leo cây như một chuyên gia."));
        listStory.add(new Story(6,1,"Bài học về tội nói dối","Một ngày, một chiếc ô tô tên là Tô Tô bỗng dưng biết nói. Nó nói với chủ nhân: \"Hãy cho tôi đi chơi!\" Chủ nhân rất ngạc nhiên nhưng cũng đồng ý. Trong khi lái xe, Tô Tô liên tục chọc cười chủ nhân bằng những câu chuyện vui. Từ đó, mỗi chuyến đi đều trở thành một cuộc phiêu lưu hài hước."));
        listStory.add(new Story(7,1,"Chưa chi đã đau","Chú chó tên Bông rất thích cái xương của mình. Một hôm, Bông mang xương ra công viên để khoe với bạn bè. Trong lúc chơi, Bông làm rơi cái xương vào một bụi cây. Khi tìm thấy, Bông phát hiện ra cái xương đã biến thành một chiếc bánh kem! Bông rất vui và mời tất cả bạn bè cùng ăn."));
        listStory.add(new Story(8,1,"Một xu và một phút","Cô gái tên Mai rất thích ngắm mình trong gương. Một hôm, gương nói: \"Tôi cũng muốn đẹp như bạn!\" Mai cười và đáp: \"Đừng lo, bạn đã rất đẹp rồi!\" Kể từ đó, mỗi lần nhìn vào gương, Mai không chỉ thấy mình mà còn thấy một người bạn."));
        listStory.add(new Story(9,1,"Sao còn chưa thả","Chú rùa tên là Rùa rất chậm chạp. Một ngày, Rùa quyết định tham gia cuộc đua với thỏ. Mọi người cười vì Rùa chậm. Nhưng Rùa không quan tâm. Chú đi đều đặn, và khi thỏ ngủ quên, Rùa đã về đích đầu tiên. Rùa đã chứng minh rằng kiên trì sẽ thắng!"));
        listStory.add(new Story(10,1,"Di tích hóa thạch","Con khỉ tên là Kiki rất nghịch ngợm. Nó luôn làm mọi người cười bằng những trò đùa. Một hôm, Kiki quyết định làm bữa tiệc sinh nhật cho chính mình. Nó mời tất cả bạn bè và chuẩn bị rất nhiều trái cây. Tuy nhiên, khi đến giờ tiệc, Kiki lại ngủ quên! Bạn bè của Kiki đã tổ chức tiệc mà không có nó, nhưng khi Kiki dậy, mọi người đã cùng nhau ăn trái cây và cười đùa rất vui vẻ."));
        listStory.add(new Story(11,1,"Nhầm lẫn tai hại","Có một cái bánh rất nổi tiếng vì độ ngon. Một hôm, cái bánh bị rơi xuống nước và trở nên ẩm ướt. Nhưng không ai lo lắng vì cái bánh biết bơi! Nó bơi ra bờ và nói: \"Dù có ở đâu, tôi vẫn là cái bánh ngon nhất!\" Từ đó, cái bánh trở thành huyền thoại của làng."));
        listStory.add(new Story(12,1,"Cảnh giác","Chú gà tên là Lúa bị mất một cánh. Lúa rất buồn và không muốn ra ngoài. Nhưng một hôm, Lúa thấy các bạn gà đang chơi vui vẻ. Lúa quyết định tập bay bằng một cánh. Cuối cùng, Lúa phát hiện ra rằng mình có thể nhảy rất cao mà không cần cánh. Lúa vui vẻ tham gia cùng các bạn!"));


        listStory.add(new Story(1,2,"2Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,2,"2Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,2,"2Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,2,"2Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,2,"2Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,2,"2Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,2,"2Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,2,"2Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,2,"2Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,2,"2Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));

        listStory.add(new Story(1,3,"3Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,3,"3Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,3,"3Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,3,"3Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,3,"3Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,3,"3Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,3,"3Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,3,"3Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,3,"3Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,3,"3Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));


        listStory.add(new Story(1,4,"4Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,4,"4Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,4,"4Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,4,"4Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,4,"4Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,4,"4Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,4,"4Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,4,"4Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,4,"4Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,4,"4Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));

        listStory.add(new Story(1,5,"5Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,5,"5Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,5,"5Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,5,"5Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,5,"5Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,5,"5Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,5,"5Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,5,"5Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,5,"5Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,5,"5Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));

        listStory.add(new Story(4,6,"6Rất lạnh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,6,"6Im lặng là vàng","Bà Bà Gà và Bà Bà Mèo tranh cãi xem ai là người chăm sóc tốt nhất cho các con của mình. Bà Bà Gà nói: \"Tôi dạy gà con biết bơi!\" Bà Bà Mèo đáp: \"Thế thì tôi dạy mèo con biết leo cây!\" Cuối cùng, cả hai quyết định dạy nhau, và kết quả là gà con bơi rất giỏi, còn mèo con leo cây như một chuyên gia."));
        listStory.add(new Story(6,6,"6Bài học về tội nói dối","Một ngày, một chiếc ô tô tên là Tô Tô bỗng dưng biết nói. Nó nói với chủ nhân: \"Hãy cho tôi đi chơi!\" Chủ nhân rất ngạc nhiên nhưng cũng đồng ý. Trong khi lái xe, Tô Tô liên tục chọc cười chủ nhân bằng những câu chuyện vui. Từ đó, mỗi chuyến đi đều trở thành một cuộc phiêu lưu hài hước."));
        listStory.add(new Story(7,6,"6Chưa chi đã đau","Chú chó tên Bông rất thích cái xương của mình. Một hôm, Bông mang xương ra công viên để khoe với bạn bè. Trong lúc chơi, Bông làm rơi cái xương vào một bụi cây. Khi tìm thấy, Bông phát hiện ra cái xương đã biến thành một chiếc bánh kem! Bông rất vui và mời tất cả bạn bè cùng ăn."));
        listStory.add(new Story(8,6,"6Một xu và một phút","Cô gái tên Mai rất thích ngắm mình trong gương. Một hôm, gương nói: \"Tôi cũng muốn đẹp như bạn!\" Mai cười và đáp: \"Đừng lo, bạn đã rất đẹp rồi!\" Kể từ đó, mỗi lần nhìn vào gương, Mai không chỉ thấy mình mà còn thấy một người bạn."));
        listStory.add(new Story(9,6,"6Sao còn chưa thả","Chú rùa tên là Rùa rất chậm chạp. Một ngày, Rùa quyết định tham gia cuộc đua với thỏ. Mọi người cười vì Rùa chậm. Nhưng Rùa không quan tâm. Chú đi đều đặn, và khi thỏ ngủ quên, Rùa đã về đích đầu tiên. Rùa đã chứng minh rằng kiên trì sẽ thắng!"));
        listStory.add(new Story(11,6,"6Di tích hóa thạch","Con khỉ tên là Kiki rất nghịch ngợm. Nó luôn làm mọi người cười bằng những trò đùa. Một hôm, Kiki quyết định làm bữa tiệc sinh nhật cho chính mình. Nó mời tất cả bạn bè và chuẩn bị rất nhiều trái cây. Tuy nhiên, khi đến giờ tiệc, Kiki lại ngủ quên! Bạn bè của Kiki đã tổ chức tiệc mà không có nó, nhưng khi Kiki dậy, mọi người đã cùng nhau ăn trái cây và cười đùa rất vui vẻ."));
        listStory.add(new Story(12,6,"6Nhầm lẫn tai hại","Có một cái bánh rất nổi tiếng vì độ ngon. Một hôm, cái bánh bị rơi xuống nước và trở nên ẩm ướt. Nhưng không ai lo lắng vì cái bánh biết bơi! Nó bơi ra bờ và nói: \"Dù có ở đâu, tôi vẫn là cái bánh ngon nhất!\" Từ đó, cái bánh trở thành huyền thoại của làng."));
        listStory.add(new Story(13,6,"6Cảnh giác","Chú gà tên là Lúa bị mất một cánh. Lúa rất buồn và không muốn ra ngoài. Nhưng một hôm, Lúa thấy các bạn gà đang chơi vui vẻ. Lúa quyết định tập bay bằng một cánh. Cuối cùng, Lúa phát hiện ra rằng mình có thể nhảy rất cao mà không cần cánh. Lúa vui vẻ tham gia cùng các bạn!"));


        listStory.add(new Story(1,7,"7Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,7,"7Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,7,"7Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,7,"7Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,7,"7Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,7,"7Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,7,"7Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,7,"7Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,7,"7Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,7,"7Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));

        listStory.add(new Story(1,8,"8Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,8,"8Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,8,"8Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,8,"8Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,8,"8Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,8,"8Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,8,"8Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,8,"8Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,8,"8Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,8,"8Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));


        listStory.add(new Story(1,9,"9Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,9,"9Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,9,"9Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,9,"9Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,9,"9Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,9,"9Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,9,"9Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,9,"9Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,9,"9Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,9,"9Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));

        listStory.add(new Story(1,10,"10Chú Chuột Thích Ăn Phô Mai","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(2,10,"10Cuộc Chiến Giữa Bà Bà Gà và Bà Bà Mèo","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(3,10,"10Tô Tô: Chiếc Ô Tô Biết Nói","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(4,10,"10Cái Xương Kỳ Diệu của Chú Chó Bông","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(5,10,"10Cô Gái và Cái Gương Thần","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(6,10,"10Rùa Chậm Chạp và Cuộc Đua Kỳ Diệu","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(7,10,"10Kiki: Con Khỉ Nghịch Ngợm","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(8,10,"10Cái Bánh và Cái Nước Mát","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(9,10,"10Lúa: Chú Gà Không Cánh","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        listStory.add(new Story(10,10,"10Bảo: Con Rồng Nhỏ Đầy Tài Năng","Chú chuột tên là Mít rất thích ăn phô mai. Một ngày, Mít tìm được một miếng phô mai to ở trong bẫy. Chú nghĩ: \"Nếu mình ăn hết, mình sẽ không phải ra ngoài!\" Thế là Mít cố gắng ăn thật nhiều, nhưng cuối cùng lại bị mắc kẹt trong bẫy. Mít học được bài học: \"Ăn phô mai có chừng mực mới vui!\""));
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Lấy Intent
        Intent intent = getIntent();
        // Lấy category ID từ extras
        int categoryId = intent.getIntExtra("categoryID", -1); // -1 là giá trị mặc định nếu không tìm thấy
        String categoryName = intent.getStringExtra("categoryName");

        tv.setText(categoryName);
        for (Story story:listStory){
            if(story.getIdCategory()==categoryId){
                listStorybyCategoryID.add(story);
            }
        }
        adapterStory = new StoryAdapter(listStorybyCategoryID,this,categoryName);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rvStory.setAdapter(adapterStory);
        rvStory.setLayoutManager(linearLayoutManager);
    }
}
