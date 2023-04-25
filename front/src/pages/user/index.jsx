import style from "./style.module.scss";
import avatar from "../../component/card-post/avatar.png";
import { Link, useNavigate, useParams } from "react-router-dom";
import {
  EditOutlined,
  HeartOutlined,
  MessageOutlined,
} from "@ant-design/icons";
import { Header } from "../../component/header";

const UserPage = () => {
  return (
    <div>
      <Header />
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
            </div>
          </div>
          <div className={style.MenuBox}>
            <div className={style.Menu}>
              <div className={style.TitleMenu}>ПУБЛИКАЦИИ</div>
            </div>
            <div className={style.Content}>
              <Link to="/post" className={style.Link}>
                  <div className={style.NamePost}>
                    10 полезных сочетаний клавиш в PyCharm
                  </div>
              </Link>
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
        </div>
      </div>
    </div>
  );
};

export default UserPage;
