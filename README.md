<div>
    <h2 id="커밋-메시지-구조">커밋 메시지 구조</h2>
    <pre class=" language-tsx">
        <code class=" language-tsx">
            <span class="token comment">// Header, Body, Footer는 빈 행으로 구분한다.</span>
                <span class="token function">타입</span> <span class="token punctuation">(</span>스코프<span class="token punctuation">)</span> <span class="token punctuation">:</span> <span class="token function">주제</span> <span class="token punctuation">(</span>제목<span class="token punctuation">)</span> <span class="token comment">// Header(헤더)</span>
                본문 <span class="token comment">// Body(바디)</span>
                바닥글 <span class="token comment">// Footer</span>
        </code>
    </pre>
</div>
<table>
    <thead>
        <tr>
            <th>타입 이름</th>
            <th>내용</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>feat</td>
            <td>새로운 기능에 대한 커밋</td>
        </tr>
        <tr>
            <td>fix</td>
            <td>버그 수정에 대한 커밋</td>
        </tr>
        <tr>
            <td>build</td>
            <td>빌드 관련 파일 수정 / 모듈 설치 또는 삭제에 대한 커밋</td>
        </tr>
        <tr>
            <td>chore</td>
            <td>그 외 자잘한 수정에 대한 커밋</td>
        </tr>
        <tr>
            <td>ci</td>
            <td>ci 관련 설정 수정에 대한 커밋</td>
        </tr>
        <tr>
            <td>docs</td>
            <td>문서 수정에 대한 커밋</td>
        </tr>
        <tr>
            <td>style</td>
            <td>코드 스타일 혹은 포맷 등에 관한 커밋</td>
        </tr>
        <tr>
            <td>refactor</td>
            <td>코드 리팩토링에 대한 커밋</td>
        </tr>
        <tr>
            <td>test</td>
            <td>테스트 코드 수정에 대한 커밋</td>
        </tr>
        <tr>
            <td>perf</td>
            <td>성능 개선에 대한 커밋</td>
        </tr>
    </tbody>
</table>

<div>
    <h2 id="작성-예시">작성 예시</h2>
    <pre class=" language-tsx">
        <code class=" language-tsx">"fix<span class="token punctuation">:</span> Safari에서 모달을 띄웠을 때 스크롤 이슈 수정
            모바일 사파리에서 Carousel 모달을 띄웠을 때<span class="token punctuation">,</span>
            모달 밖의 상하 스크롤이 움직이는 이슈 수정<span class="token punctuation">.</span>
            resolves<span class="token punctuation">:</span> #<span class="token number">1137</span>
        </code>
    </pre>
</div>
