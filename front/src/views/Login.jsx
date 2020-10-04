import React from 'react'
import {Label, Classes, Button} from "@blueprintjs/core"
import {Link} from 'react-router-dom'
import '../css/login.scss'

class Login extends React.Component {
    render() {
      return (
        <form>
        <div className="bp3-card">
            <h1>로그인</h1>
            <Label>
                <strong>아이디 or Email</strong>
                <input className={Classes.INPUT} placeholder="아이디 or Email" />
            </Label>
            <Label>
            <strong>비밀번호</strong>
                <input className={Classes.INPUT} placeholder="비밀번호" type="password" />
            </Label>
            <Button className="bp3-fill"> 로그인 </Button><br/>
            <Link to="/register">회원가입</Link><br />
            <a href="/help">아이디/비밀번호 찾기</a> 
        </div>
        <div className="divider"><br /><br /><br /><br /></div>
        </form>
      )
    }
  }
  
  export default Login