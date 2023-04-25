import style from "./style.module.scss";
import logo from "./logo.png";
import { UserOutlined } from "@ant-design/icons";
import { Link } from "react-router-dom";

export const Header = () => {
  return (
    <header className={style.Header}>
      <Link to="/">
        <div className={style.boxLogo}>
          <img className={style.Logo} src={logo}></img>
        </div>
      </Link>

      <div className={style.User}>
        <UserOutlined />
        <Link to="/registration" style={{textDecoration: 'none'}}>
          <div className={style.Exit}>Войти</div>
        </Link>
      </div>
    </header>
  );
};
