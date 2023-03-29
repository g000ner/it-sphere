import style from "./style.module.scss";
import avatar from "../../component/card-post/avatar.png";
import { HeartOutlined, MessageOutlined } from "@ant-design/icons";

const PostPage = () => {
  return (
    <div className={style.PostPage}>
      <div className={style.AuthorBox}>
        <div className={style.Author}>
          <div className={style.imgBox}>
            <img className={style.Avatar} src={avatar}></img>
          </div>
          <div className={style.Name}>
            Иван Иванов
            <div className={style.JobTitle}>Разработчик python</div>
          </div>
          <div className={style.PostCount}>10 статей</div>
        </div>
      </div>
      <div className={style.ContentBox}>
        <div className={style.Content}>
          <div className={style.Start}>
            <h1 className={style.Title}>
              10 полезных сочетаний клавиш в PyCharm{" "}
            </h1>
            <div className={style.Date}> 2 часа назад </div>
          </div>
          <div className={style.Text}>
            Сегодня я хочу поделиться с вами своими лайфхаками касательно работы
            в PyCharm, ведь мы все хотим сократить время разрабатывая проект, а
            в этом нам помогут быстрые команды при помощи сочетаний клавиш. Так
            как я предпочитаю пользоваться операционной системой семейства
            Windows, сочетания клавиш будут заточены под нее. Перед тем как
            применять данные комбинации, проследите за тем чтобы у вас стояла
            английская раскладка, иначе, команды будут совсем другие.Сегодня я
            хочу поделиться с вами своими лайфхаками касательно работы в
            PyCharm, ведь мы все хотим сократить время разрабатывая проект, а в
            этом нам помогут быстрые команды при помощи сочетаний клавиш. Так
            как я предпочитаю пользоваться операционной системой семейства
            Windows, сочетания клавиш будут заточены под нее. Перед тем как
            применять данные комбинации, проследите за тем чтобы у вас стояла
            английская раскладка, иначе, команды будут совсем другие.Сегодня я
            хочу поделиться с вами своими лайфхаками касательно работы в
            PyCharm, ведь мы все хотим сократить время разрабатывая проект, а в
            этом нам помогут быстрые команды при помощи сочетаний клавиш. Так
            как я предпочитаю пользоваться операционной системой семейства
            Windows, сочетания клавиш будут заточены под нее. Перед тем как
            применять данные комбинации, проследите за тем чтобы у вас стояла
            английская раскладка, иначе, команды будут совсем другие.
          </div>
          <div className={style.Reaction}>
            <button className={style.Like}>
              <HeartOutlined />
              <div className={style.LikeCount}>10</div>
            </button>
            <button className={style.CommentIcon}>
              <MessageOutlined />
              <div className={style.CommentCount}>3</div>
            </button>
          </div>
        </div>
      </div>
      <div className={style.CommentBox}>
        <h1 className={style.Tytle}>Комментарии</h1>
        <div className={style.CardComment}>
          <div className={style.Comment}>
            <div className={style.imgBox}>
              <img className={style.Avatar} src={avatar}></img>
            </div>
            <div className={style.Name}>Иван Иванов </div>
            <div className={style.DateComment}>2 часа назад </div>
          </div>
          <div className={style.TextComment}>
            дня я хочу поделиться с вами своими лайфхаками касательно работы в
            PyCharm, ведь мы все хотим сократить вре
          </div>
        </div>
      </div>
    </div>
  );
};

export default PostPage;
