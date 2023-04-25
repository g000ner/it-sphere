import { HeartOutlined, MessageOutlined } from "@ant-design/icons";
import style from "./style.module.scss";
import avatar from "./avatar.png";
import { Link } from "react-router-dom";

export const Card = () => {
  return (
    <li className={style.CardBox}>
      <div className={style.Card}>
        <div className={style.Start}>
          <Link to="/user" className={style.Link}>
            <div className={style.Author}>
              <div className={style.imgBox}>
                <img className={style.Avatar} src={avatar}></img>
              </div>
              <div className={style.Name}>Иван Иванов</div>
            </div>
          </Link>
          <div className={style.Date}> 2 часа назад </div>
        </div>
        <div className={style.Label}>
          10 полезных сочетаний клавиш в PyCharm
        </div>
        <div className={style.Text}>
          Сегодня я хочу поделиться с вами своими лайфхаками касательно работы в
          PyCharm, ведь мы все хотим сократить время разрабатывая проект, а в
          этом нам помогут быстрые команды при помощи сочетаний клавиш. Так как
          я предпочитаю пользоваться операционной системой семейства Windows,
          сочетания клавиш будут заточены под нее. Перед тем как применять
          данные комбинации, проследите за тем чтобы у вас стояла английская
          раскладка, иначе, команды будут совсем другие.
        </div>
        <div className={style.End}>
          <Link to="/post">
            <button className={style.ReadMore}>
              {" "}
              <u>Читать далее </u>{" "}
            </button>
          </Link>
          <div className={style.Reaction}>
            <button className={style.Like}>
              <HeartOutlined />
              <div className={style.LikeCount}>10</div>
            </button>
            <button className={style.Comment}>
              <MessageOutlined />
              <div className={style.CommentCount}>3</div>
            </button>
          </div>
        </div>
      </div>
    </li>
  );
};
