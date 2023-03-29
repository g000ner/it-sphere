import { Link } from "react-router-dom";
import style from "./style.module.scss";

const NewPost = () => {
  return (
    <div className={style.NewPostBox}>
      <div className={style.NewPost}>
        <form className={style.Form}>
          <div className={style.Title}>
            <h2 className={style.FormName}> Заголовок </h2>
            <input
              type="text"
              className={style.Form__input}
              // value={formState.title}
              name={"title"}
              // onChange={onChangeForm}
              required
            />
          </div>
          <div className={style.Title}>
            <h2 className={style.FormName}> Текст </h2>
            <input
              type="text"
              className={style.Form__input__text}
              // value={formState.title}
              name={"title"}
              // onChange={onChangeForm}
              required
            />
          </div>
          <Link to="/">
            <button className={style.AddPost}>Отправить пост</button>
          </Link>
        </form>
      </div>
    </div>
  );
};

export default NewPost;
