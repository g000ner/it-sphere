import style from "./style.module.scss";
import avatar from "../../component/card-post/avatar.png";
import { Link, useNavigate, useParams } from "react-router-dom";
import {
  EditOutlined,
  HeartOutlined,
  MessageOutlined,
} from "@ant-design/icons";

const Profile = () => {
  return (
    <div>
      <div className={style.ProfilePage}>
        <div className={style.ProfileBox}>
          <div className={style.ProfileFirstBox}>
            <div className={style.Profile}>
              <div className={style.imgBox}>
                <img className={style.Avatar} src={avatar}></img>
              </div>
              <div className={style.TextInfo}>
                <div className={style.Name}>Иван Иванов</div>
                <div className={style.Name}>@ivanovIvan</div>
                <div className={style.JobTitle}>Разработчик python</div>
              </div>
              <div className={style.Status}>Autor</div>
            </div>
            <div className={style.EditIcon}>
              <EditOutlined />
            </div>
          </div>
          <div className={style.MenuBox}>
            <div className={style.Menu}>
              <div className={style.TitleMenu}>ПУБЛИКАЦИИ</div>
              <div className={style.TitleMenu}>НА ПРОВЕРКЕ</div>
              <div className={style.TitleMenu}>ОТКЛОНЕНЫ</div>
            </div>
            <div className={style.Content}>
              <div className={style.NamePost}>
                10 полезных сочетаний клавиш в PyCharm
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
            <Link to="/new-post">
              <button className={style.WritePost}>Написать пост</button>
            </Link>
          </div>
        </div>
        <div className={style.InfoBox}>
          <div className={style.Info}>
            <h1 className={style.Title}>
              <u>ИНФОРМАЦИЯ</u>
            </h1>
            <div className={style.InfoBlock}>
              <h2 className={style.Headline}>Опубликовано</h2>
              <div className={style.CountPost}>10 cтатей</div>
            </div>
            <div className={style.InfoBlock}>
              <h2 className={style.Headline}>На рассмотрении</h2>
              <div className={style.CountPost}>10 cтатей</div>
            </div>
            <div className={style.InfoBlock}>
              <h2 className={style.Headline}>Отклонено</h2>
              <div className={style.CountPost}>10 cтатей</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Profile;
