import style from './style.module.scss';
import logo from './logo.png'
import {UserOutlined } from '@ant-design/icons';


export const Header = () => {
  return (
    <header className={style.Header}>
      <div className={style.boxLogo}>
        <img className={style.Logo} src={logo}></img>
      </div>
      
      <div className={style.User}>
        <UserOutlined/>
        <div className={style.Exit}>Войти</div>
      </div>
    </header>
  );
};
